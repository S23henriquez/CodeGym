package com.exemple.codegym.data

import com.exemple.codegym.models.UserProfile
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.util.Calendar

class UserRepository {

    private val auth = FirebaseAuth.getInstance()
    private val db   = FirebaseFirestore.getInstance()

    suspend fun registerUser(
        name: String,
        email: String,
        password: String
    ): Result<String> = runCatching {
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        val uid = result.user!!.uid
        val profile = UserProfile(uid = uid, name = name, email = email)
        db.collection("users").document(uid).set(profile).await()
        uid
    }

    suspend fun loginUser(email: String, password: String): Result<String> = runCatching {
        val result = auth.signInWithEmailAndPassword(email, password).await()
        result.user!!.uid
    }

    suspend fun saveSelectedLanguage(uid: String, language: String): Result<Unit> = runCatching {
        db.collection("users").document(uid)
            .update("selectedLanguage", language)
            .await()
        Unit
    }

    suspend fun saveTestResult(
        uid: String,
        language: String,
        level: String
    ): Result<Unit> = runCatching {
        val updates = mapOf(
            "selectedLanguage" to language,
            "level" to level,
            "hasCompletedTest" to true
        )
        db.collection("users").document(uid).update(updates).await()
        Unit
    }

    suspend fun getProfile(uid: String): Result<UserProfile> = runCatching {
        val snap = db.collection("users").document(uid).get().await()
        snap.toObject(UserProfile::class.java) ?: throw Exception("Perfil no encontrado")
    }

    /**
     * Marca lección como completada + suma XP + actualiza racha + comprueba logros.
     * Devuelve el perfil actualizado y la lista de logros NUEVOS desbloqueados.
     */
    suspend fun completeLesson(
        uid: String,
        lessonId: String,
        xpGained: Int
    ): Result<LessonCompletionResult> = runCatching {
        val ref = db.collection("users").document(uid)

        val pair = db.runTransaction { tx ->
            val snap = tx.get(ref)
            val profile = snap.toObject(UserProfile::class.java)
                ?: throw Exception("Perfil no encontrado")

            // Si ya estaba completada, NO sumamos XP (evitar farmeo)
            val alreadyCompleted = lessonId in profile.completedLessons
            val effectiveXp = if (profile.isDoubleXpActive()) xpGained * 2 else xpGained
            val actualXp = if (alreadyCompleted) 0 else effectiveXp

            val newCompletedList = if (alreadyCompleted)
                profile.completedLessons
            else
                profile.completedLessons + lessonId

            val newStreak = calculateNewStreak(
                lastActiveTimestamp = profile.lastActiveDate,
                currentStreak = profile.streak,
                isStreakShieldActive = profile.isStreakShieldActive()
            )

            val tempProfile = profile.copy(
                xp = profile.xp + actualXp,
                totalLessonsCompleted = newCompletedList.size,
                streak = newStreak,
                lastActiveDate = System.currentTimeMillis(),
                completedLessons = newCompletedList
            )

            val finalProfile = tempProfile

            tx.set(ref, finalProfile)
            Pair(finalProfile, emptyList<String>())
        }.await()

        LessonCompletionResult(pair.first, pair.second)
    }

    suspend fun saveTheme(uid: String, theme: String): Result<Unit> = runCatching {
        db.collection("users").document(uid)
            .update("theme", theme)
            .await()
        Unit
    }

    private fun calculateNewStreak(
        lastActiveTimestamp: Long,
        currentStreak: Int,
        isStreakShieldActive: Boolean
    ): Int {
        if (lastActiveTimestamp == 0L) return 1

        val lastCal = Calendar.getInstance().apply { timeInMillis = lastActiveTimestamp }
        val nowCal  = Calendar.getInstance()

        val sameDay = lastCal.get(Calendar.YEAR) == nowCal.get(Calendar.YEAR) &&
                lastCal.get(Calendar.DAY_OF_YEAR) == nowCal.get(Calendar.DAY_OF_YEAR)
        if (sameDay) return currentStreak

        val diffMillis = nowCal.timeInMillis - lastCal.timeInMillis
        val diffDays = diffMillis / (24 * 60 * 60 * 1000)

        return if (diffDays == 1L) {
            currentStreak + 1
        } else if (diffDays > 1L && isStreakShieldActive) {
            currentStreak
        } else {
            1
        }
    }

    fun currentUid(): String? = auth.currentUser?.uid
    fun isLoggedIn(): Boolean = auth.currentUser != null
    fun logout() = auth.signOut()
}

data class LessonCompletionResult(
    val profile: UserProfile,
    val newAchievements: List<String>
)