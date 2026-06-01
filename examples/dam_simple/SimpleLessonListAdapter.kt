package com.exemple.codegym.examples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter RecyclerView mínimo y comentado.
class SimpleLessonListAdapter(
    private val items: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<SimpleLessonListAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvSimpleLessonTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_simple_lesson_row, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val title = items[position]
        holder.tvTitle.text = title

        // Maneja el clic: delega la acción al callback
        holder.itemView.setOnClickListener { onClick(title) }
    }

    override fun getItemCount(): Int = items.size
}
