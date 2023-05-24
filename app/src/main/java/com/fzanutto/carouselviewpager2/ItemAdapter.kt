package com.fzanutto.carouselviewpager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fzanutto.carouselviewpager2.databinding.PagerItemBinding

class ItemAdapter(
    private val imageResources: List<Int>,
    private val labels: List<String>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = PagerItemBinding.inflate(layoutInflater, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageResources.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.view.setBackgroundResource(imageResources[position])
        holder.binding.label.text = labels[position]
    }

    inner class ItemViewHolder(val binding: PagerItemBinding): RecyclerView.ViewHolder(binding.root)
}
