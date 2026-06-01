package com.exemple.codegym.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.exemple.codegym.R
import com.exemple.codegym.databinding.ItemSyllabusUnitBinding
import com.exemple.codegym.models.SyllabusUnit

class SyllabusAdapter(
    private val units: List<SyllabusUnit>
) : RecyclerView.Adapter<SyllabusAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemSyllabusUnitBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSyllabusUnitBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val unit = units[position]
        val context = holder.itemView.context

        holder.binding.tvUnitNumber.text = context.getString(R.string.unit_label, unit.unitNumber)
        holder.binding.tvUnitTitle.text  = unit.title

        // Listado de temas con bullets
        holder.binding.tvUnitTopics.text = unit.topics.joinToString("\n") { "▸ $it" }

        // Badge IA si aplica
        holder.binding.tvAiBadge.visibility = if (unit.isAiGenerated) View.VISIBLE else View.GONE
        holder.binding.tvAiBadge.text = context.getString(R.string.ai_badge)

        // Icono candado / desbloqueado
        if (unit.isUnlocked) {
            holder.binding.tvLockIcon.text = "✓"
            holder.binding.tvLockIcon.setTextColor(
                ContextCompat.getColor(context, R.color.green_correct)
            )
            holder.itemView.alpha = 1f
        } else {
            holder.binding.tvLockIcon.text = "🔒"
            holder.itemView.alpha = 0.55f
        }
    }

    override fun getItemCount() = units.size
}