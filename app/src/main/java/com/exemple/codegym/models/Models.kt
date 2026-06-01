package com.exemple.codegym.models

// ============ MAQUETA ORIGINAL ============
data class Language(
    val name: String,
    val icon: String,
    val level: Int,
    val progress: Int,
    val isActive: Boolean = false
)

data class Question(
    val type: String,
    val title: String,
    val subtitle: String,
    val codeSnippet: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class Badge(
    val icon: String,
    val name: String,
    val earned: Boolean
)

// ============ FIREBASE / PERFIL DE USUARIO ============
data class UserProfile(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val selectedLanguage: String = "",
    val level: String = UserLevel.PRINCIPIANTE.label,
    val xp: Int = 0,
    val streak: Int = 0,
    val totalLessonsCompleted: Int = 0,
    val hasCompletedTest: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val lastActiveDate: Long = 0L,
    val completedLessons: List<String> = emptyList(),
    val unlockedAchievements: List<String> = emptyList(),
    val theme: String = "DARK",
    val extraLives: Int = 0,
    val isPremium: Boolean = false,          // 🆕 Sin anuncios
    val premiumUntil: Long = 0L,             // 🆕 Fecha de expiración Premium
    val doubleXpUntil: Long = 0L,            // 🆕 Booster doble XP
    val streakShieldUntil: Long = 0L,        // 🆕 Booster protección racha
    val unlockedBadges: List<String> = emptyList() // 🆕 Insignias compradas
) {
    constructor() : this("", "", "", "", UserLevel.PRINCIPIANTE.label, 0, 0, 0, false, 0L, 0L, emptyList(), emptyList(), "DARK", 0, false, 0L, 0L, 0L, emptyList())

    fun isPremiumActive(): Boolean = isPremium && premiumUntil > System.currentTimeMillis()
    fun isDoubleXpActive(): Boolean = doubleXpUntil > System.currentTimeMillis()
    fun isStreakShieldActive(): Boolean = streakShieldUntil > System.currentTimeMillis()
}

enum class UserLevel(val label: String, val minScore: Int) {
    PRINCIPIANTE("Principiante", 0),
    INTERMEDIO("Intermedio", 5),
    AVANZADO("Avanzado", 8)
}

// ============ TEST DE NIVEL ============
data class LevelQuestion(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctIndex: Int,
    val language: String
)

// ============ SYLLABUS / TEMARIO ============
data class SyllabusUnit(
    val unitNumber: Int,
    val title: String,
    val topics: List<String>,
    val isUnlocked: Boolean = false,
    val isAiGenerated: Boolean = false
)

// ============ LECCIONES ============
data class Lesson(
    val id: String,
    val language: String,
    val unitNumber: Int,
    val title: String,
    val theoryText: String,
    val codeExample: String,
    val xpReward: Int = 20,
    val exercises: List<LessonExercise>
)

data class LessonExercise(
    val type: ExerciseType,
    val question: String,
    val codeSnippet: String = "",
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

enum class ExerciseType {
    MULTIPLE_CHOICE,
    FILL_BLANK
}

// ============ EJERCICIO ADAPTADO A FIREBASE MULTI-IDIOMA ============
data class FirestoreExercise(
    val type: String = "MULTIPLE_CHOICE",
    val question: Map<String, String> = emptyMap(),
    val explanation: Map<String, String> = emptyMap(),
    val options: Map<String, List<String>> = emptyMap(),
    val correctIndex: Int = 0,
    val codeSnippet: String = ""
) {
    fun getTextForCurrentLanguage(context: android.content.Context, mapToCheck: Map<String, String>): String {
        val currentLang = com.exemple.codegym.utils.LocaleHelper.getSavedLanguage(context)
        return mapToCheck[currentLang] 
            ?: mapToCheck["en"] 
            ?: mapToCheck.values.firstOrNull() 
            ?: "Texto no disponible"
    }

    fun getOptionsForCurrentLanguage(context: android.content.Context): List<String> {
        val currentLang = com.exemple.codegym.utils.LocaleHelper.getSavedLanguage(context)
        return options[currentLang] 
            ?: options["en"] 
            ?: options.values.firstOrNull() 
            ?: emptyList()
    }
}

// ============ LOGROS 🆕 ============
data class Achievement(
    val id: String,
    val emoji: String,
    val title: String,
    val description: String,
    val xpReward: Int,
    val rarity: AchievementRarity = AchievementRarity.COMMON
)

enum class AchievementRarity(val label: String, val colorHex: String) {
    COMMON("Común", "#888888"),
    RARE("Raro", "#58A6FF"),
    EPIC("Épico", "#D2A8FF"),
    LEGENDARY("Legendario", "#F2C94C")
}