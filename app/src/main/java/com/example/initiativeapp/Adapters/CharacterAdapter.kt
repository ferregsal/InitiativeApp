package com.example.initiativeapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.initiativeapp.Data.Character
import com.example.initiativeapp.databinding.ItemCharacterBinding

class CharacterAdapter(
private var dataSet: List<Character> = emptyList(),
private val onItemClickListener: (Int) -> Unit,
private val onItemSaveClickListener: (Int, String) -> Unit,
private val onItemDeleteClickListener: (Int) -> Unit,
private val onItemCheckedClickListener: (Int) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.render(dataSet[position])
        holder.itemView.setOnClickListener{onItemClickListener(position)}
        holder.binding.deleteImageButton.setOnClickListener {
            onItemDeleteClickListener(position)
        }

        holder.itemView.setOnLongClickListener{
            if (!holder.isEditing) {
                holder.toggleEditMode()
            }
            return@setOnLongClickListener true
        }
        holder.binding.saveImageButton.setOnClickListener {
            holder.toggleEditMode()

        }


    }

    override fun getItemCount(): Int = dataSet.size
    fun updateData(dataSet: List<Character>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }


    class CharacterViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        var isEditing = false

        fun render(category: Character) {
            binding.categoryTextView.text = category.name
            binding.categoryEditText.setText(category.name)

        }

        fun toggleEditMode() {
            if (isEditing) {
                binding.deleteLayout.visibility=View.VISIBLE
                binding.saveLayout.visibility=View.GONE
            } else {
                binding.deleteLayout.visibility=View.GONE
                binding.saveLayout.visibility=View.VISIBLE
            }
            isEditing = !isEditing
        }
    }
}