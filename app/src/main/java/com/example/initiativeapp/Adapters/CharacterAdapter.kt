package com.example.initiativeapp.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.initiativeapp.Data.Character
import com.example.initiativeapp.Data.CharacterDAO
import com.example.initiativeapp.R
import com.example.initiativeapp.databinding.ItemCharacterBinding


class CharacterAdapter(
private var dataSet: List<Character> = emptyList(),
private val onItemClickListener: (Int) -> Unit,
private val onItemSaveClickListener: (Int, String) -> Unit,
private val onItemDeleteClickListener: (Int) -> Unit,
private val onItemEditClickListener: (Int) -> Unit,
private val onItemAddHpClickListener: (Int) -> Unit,
private val onItemSubstractHpClickListener: (Int) -> Unit,
private val onItemBlindedClickListener: (Int) -> Unit,
private val onItemCharmedClickListener: (Int) -> Unit,
private val onItemDeafenedClickListener: (Int) -> Unit,
private val onItemExhaustedClickListener: (Int) -> Unit,
private val onItemFrightenedClickListener: (Int) -> Unit,
private val onItemGrappledClickListener: (Int) -> Unit,
private val onItemIncapacitatedClickListener: (Int) -> Unit,
private val onItemInvisibleClickListener: (Int) -> Unit,
private val onItemParalyzedClickListener: (Int) -> Unit,
private val onItemPetrifiedClickListener: (Int) -> Unit,
private val onItemPoisonedClickListener: (Int) -> Unit,
private val onItemProneClickListener: (Int) -> Unit,
private val onItemRestrainedClickListener: (Int) -> Unit,
private val onItemStunnedClickListener: (Int) -> Unit,
private val onItemUnconsciousClickListener: (Int) -> Unit,
private val characterDAO: CharacterDAO


) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val characterList: List<Character> = characterDAO.findAll()
        val character = characterList[position]

        holder.render(dataSet[position])
        holder.itemView.setOnClickListener { onItemClickListener(position) }
        holder.binding.deleteImageButton.setOnClickListener { onItemDeleteClickListener(position) }
        holder.binding.editImageButton.setOnClickListener { onItemEditClickListener(position) }
        holder.binding.addHpButton.setOnClickListener { onItemAddHpClickListener(position) }
        holder.binding.substractHpButton.setOnClickListener { onItemSubstractHpClickListener(position) }

        holder.binding.blindedImageView.setOnClickListener {
            character.blinded = !character.blinded
            onItemBlindedClickListener(position)
            if (character.blinded) {
                holder.binding.blindedImageView.setImageResource(R.mipmap.ic_blinded)
            } else {
                holder.binding.blindedImageView.setImageResource(R.mipmap.ic_blinded_false)
            }
        }

        holder.binding.charmedImageView.setOnClickListener {
            character.charmed = !character.charmed
            onItemCharmedClickListener(position)
            if (character.charmed) {
                holder.binding.charmedImageView.setImageResource(R.mipmap.ic_charmed)
            } else {
                holder.binding.charmedImageView.setImageResource(R.mipmap.ic_charmed_false)
            }
        }

        holder.binding.deafenedImageView.setOnClickListener {
            character.deafened = !character.deafened
            onItemDeafenedClickListener(position)
            if (character.deafened) {
                holder.binding.deafenedImageView.setImageResource(R.mipmap.ic_deafened)
            } else {
                holder.binding.deafenedImageView.setImageResource(R.mipmap.ic_deafened_false)
            }
        }

        holder.binding.exhaustedImageView.setOnClickListener {
            character.exhausted = !character.exhausted
            onItemExhaustedClickListener(position)
            if (character.exhausted) {
                holder.binding.exhaustedImageView.setImageResource(R.mipmap.ic_exhausted)
            } else {
                holder.binding.exhaustedImageView.setImageResource(R.mipmap.ic_exhausted_false)
            }
        }

        holder.binding.frightenedImageView.setOnClickListener {
            character.frightened = !character.frightened
            onItemFrightenedClickListener(position)
            if (character.frightened) {
                holder.binding.frightenedImageView.setImageResource(R.mipmap.ic_frightened)
            } else {
                holder.binding.frightenedImageView.setImageResource(R.mipmap.ic_frightened_false)
            }
        }

        holder.binding.grappledImageView.setOnClickListener {
            character.grappled = !character.grappled
            onItemGrappledClickListener(position)
            if (character.grappled) {
                holder.binding.grappledImageView.setImageResource(R.mipmap.ic_grappled)
            } else {
                holder.binding.grappledImageView.setImageResource(R.mipmap.ic_grappled_false)
            }
        }

        holder.binding.incapacitatedImageView.setOnClickListener {
            character.incapacitated = !character.incapacitated
            onItemIncapacitatedClickListener(position)
            if (character.incapacitated) {
                holder.binding.incapacitatedImageView.setImageResource(R.mipmap.ic_incapacitated)
            } else {
                holder.binding.incapacitatedImageView.setImageResource(R.mipmap.ic_incapacitated_false)
            }
        }

        holder.binding.invisibleImageView.setOnClickListener {
            character.invisible = !character.invisible
            onItemInvisibleClickListener(position)
            if (character.invisible) {
                holder.binding.invisibleImageView.setImageResource(R.mipmap.ic_invisible)
            } else {
                holder.binding.invisibleImageView.setImageResource(R.mipmap.ic_invisible_false)
            }
        }

        holder.binding.paralyzedImageView.setOnClickListener {
            character.paralyzed = !character.paralyzed
            onItemParalyzedClickListener(position)
            if (character.paralyzed) {
                holder.binding.paralyzedImageView.setImageResource(R.mipmap.ic_paralyzed)
            } else {
                holder.binding.paralyzedImageView.setImageResource(R.mipmap.ic_paralyzed_false)
            }
        }

        holder.binding.petrifiedImageView.setOnClickListener {
            character.petrified = !character.petrified
            onItemPetrifiedClickListener(position)
            if (character.petrified) {
                holder.binding.petrifiedImageView.setImageResource(R.mipmap.ic_petrified)
            } else {
                holder.binding.petrifiedImageView.setImageResource(R.mipmap.ic_petrified_false)
            }
        }

        holder.binding.poisonedImageView.setOnClickListener {
            character.poisoned = !character.poisoned
            onItemPoisonedClickListener(position)
            if (character.poisoned) {
                holder.binding.poisonedImageView.setImageResource(R.mipmap.ic_poisoned)
            } else {
                holder.binding.poisonedImageView.setImageResource(R.mipmap.ic_poisoned_false)
            }
        }

        holder.binding.proneImageView.setOnClickListener {
            character.prone = !character.prone
            onItemProneClickListener(position)
            if (character.prone) {
                holder.binding.proneImageView.setImageResource(R.mipmap.ic_prone)
            } else {
                holder.binding.proneImageView.setImageResource(R.mipmap.ic_prone_false)
            }
        }

        holder.binding.restrainedImageView.setOnClickListener {
            character.restrained = !character.restrained
            onItemRestrainedClickListener(position)
            if (character.restrained) {
                holder.binding.restrainedImageView.setImageResource(R.mipmap.ic_restrained)
            } else {
                holder.binding.restrainedImageView.setImageResource(R.mipmap.ic_restrained_false)
            }
        }

        holder.binding.stunnedImageView.setOnClickListener {
            character.stunned = !character.stunned
            onItemStunnedClickListener(position)
            if (character.stunned) {
                holder.binding.stunnedImageView.setImageResource(R.mipmap.ic_stunned)
            } else {
                holder.binding.stunnedImageView.setImageResource(R.mipmap.ic_stunned_false)
            }
        }

        holder.binding.unconsciousImageView.setOnClickListener {
            character.unconscious = !character.unconscious
            onItemUnconsciousClickListener(position)

            if (character.unconscious) {
                holder.binding.unconsciousImageView.setImageResource(R.mipmap.ic_unconscious)
                Log.d("Boolean Unconscious", "${character.unconscious}")
            } else {
                holder.binding.unconsciousImageView.setImageResource(R.mipmap.ic_unconscious_false)
                Log.d("Boolean Unconscious", "${character.unconscious}")
            }
        }
        /*  holder.itemView.setOnLongClickListener{

              }
              return@setOnLongClickListener true
          }*/

    }

    override fun getItemCount(): Int = dataSet.size
    fun updateData(dataSet: List<Character>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }


    class CharacterViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        var isEditing = false

        fun render(character: Character) {
            binding.nameTextView.text = character.name
            binding.initTextview.text = character.initiative.toString()
            binding.hpTextview.text = character.hp.toString()


        }

    }
}