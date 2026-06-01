Simple DAM examples

Archivos creados:
- SimpleLessonActivity.kt : Activity muy simple que muestra una lista de lecciones.
- SimpleLessonListAdapter.kt : Adapter mínimo para RecyclerView.
- activity_simple_lesson.xml : Layout con RecyclerView.
- item_simple_lesson_row.xml : Layout de fila simple.

Cómo usar (sugerencia para clase):
- Copiar `activity_simple_lesson.xml` y `item_simple_lesson_row.xml` en `app/src/main/res/layout/`.
- Copiar los `.kt` al paquete `com.exemple.codegym.examples` dentro de `app/src/main/java/`.
- Abrir `SimpleLessonActivity` desde otra Activity con un `Intent` para probar.

Notas educativas:
- El código está intencionadamente simple y comentado para que estudiantes entiendan el flujo: Activity -> RecyclerView -> Adapter -> onClick.
- No se usan dependencias externas ni vistas complejas.
