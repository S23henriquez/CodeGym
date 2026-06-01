package com.exemple.codegym.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.exemple.codegym.R
import com.exemple.codegym.databinding.ItemLanguageCardBinding
import com.exemple.codegym.models.Language

class LanguageAdapter(
    private val languages: List<Language>,
    private val onClick: (Language) -> Unit
) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLanguageCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLanguageCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lang = languages[position]
        val context = holder.itemView.context
        val density = context.resources.displayMetrics.density

        holder.binding.tvLangIcon.text  = lang.icon
        holder.binding.tvLangName.text  = lang.name
        holder.binding.tvLangLevel.text = if (lang.level > 0) "Niv. ${lang.level}" else holder.itemView.context.getString(R.string.new_tag)

        val card = holder.binding.cardLanguage

        if (lang.isActive) {
            card.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.red_card_bg)
            )
            card.strokeColor = ContextCompat.getColor(context, R.color.red_primary)
            card.strokeWidth = (4 * density).toInt()
        } else {
            card.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.surface2)
            )
            card.strokeColor = ContextCompat.getColor(context, R.color.border)
            card.strokeWidth = (2 * density).toInt()
        }

        card.setOnClickListener { onClick(lang) }
    }

    override fun getItemCount() = languages.size
}