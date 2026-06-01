package com.exemple.codegym.data

import com.exemple.codegym.data.lessons.CppLessons
import com.exemple.codegym.data.lessons.JavaLessons
import com.exemple.codegym.data.lessons.KotlinLessons
import com.exemple.codegym.data.lessons.PythonLessons
import com.exemple.codegym.data.lessons.SqlLessons
import com.exemple.codegym.models.Lesson

/**
 * Repositorio central de lecciones. Delega cada lenguaje a su archivo dedicado
 * en data/lessons/ para mantener el código modular y fácil de mantener.
 *
 * Total actual: ~50 lecciones · ~250 ejercicios.
 */
object LessonRepository {

    private fun lessonsForLocale(appLanguageCode: String): Map<String, List<Lesson>> {
        return when (appLanguageCode.lowercase()) {
            "en" -> mapOf(
                "SQL"    to com.exemple.codegym.data.lessons_i18n.en.SqlLessonsEn.lessons,
                "Python" to com.exemple.codegym.data.lessons_i18n.en.PythonLessonsEn.lessons,
                "Java"   to com.exemple.codegym.data.lessons_i18n.en.JavaLessonsEn.lessons,
                "Kotlin" to com.exemple.codegym.data.lessons_i18n.en.KotlinLessonsEn.lessons,
                "C++"    to com.exemple.codegym.data.lessons_i18n.en.CppLessonsEn.lessons
            )
            "ca" -> mapOf(
                "SQL"    to com.exemple.codegym.data.lessons_i18n.ca.SqlLessonsCa.lessons,
                "Python" to com.exemple.codegym.data.lessons_i18n.ca.PythonLessonsCa.lessons,
                "Java"   to com.exemple.codegym.data.lessons_i18n.ca.JavaLessonsCa.lessons,
                "Kotlin" to com.exemple.codegym.data.lessons_i18n.ca.KotlinLessonsCa.lessons,
                "C++"    to com.exemple.codegym.data.lessons_i18n.ca.CppLessonsCa.lessons
            )
            "fr" -> mapOf(
                "SQL"    to com.exemple.codegym.data.lessons_i18n.fr.SqlLessonsFr.lessons,
                "Python" to com.exemple.codegym.data.lessons_i18n.fr.PythonLessonsFr.lessons,
                "Java"   to com.exemple.codegym.data.lessons.JavaLessons.lessons,
                "Kotlin" to com.exemple.codegym.data.lessons.KotlinLessons.lessons,
                "C++"    to com.exemple.codegym.data.lessons.CppLessons.lessons
            )
            else -> ALL_LESSONS
        }
    }

    private val ALL_LESSONS: Map<String, List<Lesson>> = mapOf(
        "Python" to PythonLessons.lessons,
        "Java"   to JavaLessons.lessons,
        "Kotlin" to KotlinLessons.lessons,
        "C++"    to CppLessons.lessons,
        "SQL"    to SqlLessons.lessons
    )

    /** Devuelve todas las lecciones de un lenguaje */
    fun getLessons(language: String): List<Lesson> =
        ALL_LESSONS[language] ?: emptyList()

    /** Devuelve todas las lecciones de un lenguaje, según idioma de la app (es/en/ca/fr). */
    fun getLessons(language: String, appLanguageCode: String): List<Lesson> =
        lessonsForLocale(appLanguageCode)[language] ?: emptyList()

    /** Devuelve una lección concreta por id */
    fun getLessonById(language: String, lessonId: String): Lesson? =
        getLessons(language).find { it.id == lessonId }

    /** Devuelve una lección concreta por id, según idioma de la app (es/en/ca/fr). */
    fun getLessonById(language: String, lessonId: String, appLanguageCode: String): Lesson? =
        getLessons(language, appLanguageCode).find { it.id == lessonId }

    /** Lecciones agrupadas por unidad (útil para mostrar por temario) */
    fun getLessonsByUnit(language: String, unitNumber: Int): List<Lesson> =
        getLessons(language).filter { it.unitNumber == unitNumber }

    /** Lecciones agrupadas por unidad, según idioma de la app (es/en/ca/fr). */
    fun getLessonsByUnit(language: String, unitNumber: Int, appLanguageCode: String): List<Lesson> =
        getLessons(language, appLanguageCode).filter { it.unitNumber == unitNumber }

    /** Total de lecciones disponibles en la app (estadística) */
    fun totalLessonsCount(): Int =
        ALL_LESSONS.values.sumOf { it.size }
}