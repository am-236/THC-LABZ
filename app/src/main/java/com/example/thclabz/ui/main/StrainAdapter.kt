package com.example.thclabz.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thclabz.data.Strain
import com.example.thclabz.databinding.ItemStrainBinding

class StrainAdapter : RecyclerView.Adapter<StrainAdapter.StrainViewHolder>() {
    private var strainList = listOf<Strain>()

    fun submitList(list: List<Strain>) {
        strainList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StrainViewHolder {
        val binding = ItemStrainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StrainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StrainViewHolder, position: Int) {
        val strain = strainList[position]
        holder.bind(strain)
    }

    override fun getItemCount() = strainList.size

    inner class StrainViewHolder(private val binding: ItemStrainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(strain: Strain) {
            binding.tvStrainName.text = strain.name
            binding.tvStrainType.text = strain.type
            binding.tvThcContent.text = "THC: ${strain.thcContent}"
        }
    }
}