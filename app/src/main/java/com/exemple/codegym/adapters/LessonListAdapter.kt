package com.exemple.codegym.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exemple.codegym.R
import com.exemple.codegym.databinding.ItemLessonRowBinding
import com.exemple.codegym.models.Lesson

class LessonListAdapter(
    private val lessons: List<Lesson>,
    private val completedLessonIds: Set<String>,
    private val onClick: (Lesson) -> Unit
) : RecyclerView.Adapter<LessonListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLessonRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLessonRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lesson = lessons[position]
        val number = position + 1
        val isCompleted = lesson.id in completedLessonIds

        holder.binding.tvLessonTitle.text = lesson.title

        if (isCompleted) {
            // Lección completada: número sustituido por check verde
            holder.binding.tvLessonNumber.text = "✓"
            holder.binding.tvLessonNumber.setBackgroundResource(R.drawable.circle_green)
            holder.itemView.alpha = 0.7f
        } else {
            // Lección sin hacer
            holder.binding.tvLessonNumber.text = number.toString()
            holder.binding.tvLessonNumber.setBackgroundResource(R.drawable.circle_red)
            holder.itemView.alpha = 1f
        }

        holder.itemView.setOnClickListener { onClick(lesson) }
    }

    override fun getItemCount() = lessons.size
}