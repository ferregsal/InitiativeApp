package com.example.initiativeapp.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopeapp.utils.SessionManager
import com.example.initiativeapp.Data.Character
import com.example.initiativeapp.Data.CharacterDAO
import com.example.initiativeapp.Data.Conditions
import com.example.initiativeapp.R
import com.example.initiativeapp.databinding.ItemCharacterBinding


class CharacterAdapter(
private var dataSet: List<Character> = emptyList(),
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
private val characterDAO: CharacterDAO,




) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val sessionManager = SessionManager(holder.itemView.context)
        val characterList: List<Character> = characterDAO.findAll()
        val character = characterList[position]
        val storedInitiative = sessionManager.getInitiative(character.id)

        holder.render(character, storedInitiative)
        holder.binding.deleteImageButton.setOnClickListener { onItemDeleteClickListener(position) }
        holder.binding.editImageButton.setOnClickListener { onItemEditClickListener(position) }
        holder.binding.addHpButton.setOnClickListener { onItemAddHpClickListener(position) }
        holder.binding.substractHpButton.setOnClickListener { onItemSubstractHpClickListener(position) }
        setCharacterImages(holder, character)
        holder.binding.blindedImageView.setOnClickListener {
            character.blinded = !character.blinded
            onItemBlindedClickListener(position)
            if (character.blinded) {
                holder.binding.blindedImageView.setImageResource(R.mipmap.ic_blinded)
            } else {
                holder.binding.blindedImageView.setImageResource(R.mipmap.ic_blinded_false)
            }
            characterDAO.update(character)
        }



        holder.binding.charmedImageView.setOnClickListener {
            character.charmed = !character.charmed
            onItemCharmedClickListener(position)
            if (character.charmed) {
                holder.binding.charmedImageView.setImageResource(R.mipmap.ic_charmed)
            } else {
                holder.binding.charmedImageView.setImageResource(R.mipmap.ic_charmed_false)
            }
            characterDAO.update(character)
        }



        holder.binding.deafenedImageView.setOnClickListener {
            character.deafened = !character.deafened
            onItemDeafenedClickListener(position)
            if (character.deafened) {
                holder.binding.deafenedImageView.setImageResource(R.mipmap.ic_deafened)
            } else {
                holder.binding.deafenedImageView.setImageResource(R.mipmap.ic_deafened_false)
            }
            characterDAO.update(character)
        }

        holder.binding.exhaustedImageView.setOnClickListener {
            character.exhausted = !character.exhausted
            onItemExhaustedClickListener(position)
            if (character.exhausted) {
                holder.binding.exhaustedImageView.setImageResource(R.mipmap.ic_exhausted)
            } else {
                holder.binding.exhaustedImageView.setImageResource(R.mipmap.ic_exhausted_false)
            }
            characterDAO.update(character)
        }

        holder.binding.frightenedImageView.setOnClickListener {
            character.frightened = !character.frightened
            onItemFrightenedClickListener(position)
            if (character.frightened) {
                holder.binding.frightenedImageView.setImageResource(R.mipmap.ic_frightened)
            } else {
                holder.binding.frightenedImageView.setImageResource(R.mipmap.ic_frightened_false)
            }
            characterDAO.update(character)
        }

        holder.binding.grappledImageView.setOnClickListener {
            character.grappled = !character.grappled
            onItemGrappledClickListener(position)
            if (character.grappled) {
                holder.binding.grappledImageView.setImageResource(R.mipmap.ic_grappled)
            } else {
                holder.binding.grappledImageView.setImageResource(R.mipmap.ic_grappled_false)
            }
            characterDAO.update(character)
        }

        holder.binding.incapacitatedImageView.setOnClickListener {
            character.incapacitated = !character.incapacitated
            onItemIncapacitatedClickListener(position)
            if (character.incapacitated) {
                holder.binding.incapacitatedImageView.setImageResource(R.mipmap.ic_incapacitated)
            } else {
                holder.binding.incapacitatedImageView.setImageResource(R.mipmap.ic_incapacitated_false)
            }
            characterDAO.update(character)
        }

        holder.binding.invisibleImageView.setOnClickListener {
            character.invisible = !character.invisible
            onItemInvisibleClickListener(position)
            if (character.invisible) {
                holder.binding.invisibleImageView.setImageResource(R.mipmap.ic_invisible)
            } else {
                holder.binding.invisibleImageView.setImageResource(R.mipmap.ic_invisible_false)
            }
            characterDAO.update(character)
        }

        holder.binding.paralyzedImageView.setOnClickListener {
            character.paralyzed = !character.paralyzed
            onItemParalyzedClickListener(position)
            if (character.paralyzed) {
                holder.binding.paralyzedImageView.setImageResource(R.mipmap.ic_paralyzed)
            } else {
                holder.binding.paralyzedImageView.setImageResource(R.mipmap.ic_paralyzed_false)
            }
            characterDAO.update(character)
        }

        holder.binding.petrifiedImageView.setOnClickListener {
            character.petrified = !character.petrified
            onItemPetrifiedClickListener(position)
            if (character.petrified) {
                holder.binding.petrifiedImageView.setImageResource(R.mipmap.ic_petrified)
            } else {
                holder.binding.petrifiedImageView.setImageResource(R.mipmap.ic_petrified_false)
            }
            characterDAO.update(character)
        }

        holder.binding.poisonedImageView.setOnClickListener {
            character.poisoned = !character.poisoned
            onItemPoisonedClickListener(position)
            if (character.poisoned) {
                holder.binding.poisonedImageView.setImageResource(R.mipmap.ic_poisoned)
            } else {
                holder.binding.poisonedImageView.setImageResource(R.mipmap.ic_poisoned_false)

            }
            characterDAO.update(character)
        }

        holder.binding.proneImageView.setOnClickListener {
            character.prone = !character.prone
            onItemProneClickListener(position)
            if (character.prone) {
                holder.binding.proneImageView.setImageResource(R.mipmap.ic_prone)
            } else {
                holder.binding.proneImageView.setImageResource(R.mipmap.ic_prone_false)
            }
            characterDAO.update(character)
        }

        holder.binding.restrainedImageView.setOnClickListener {
            character.restrained = !character.restrained
            onItemRestrainedClickListener(position)
            if (character.restrained) {
                holder.binding.restrainedImageView.setImageResource(R.mipmap.ic_restrained)
            } else {
                holder.binding.restrainedImageView.setImageResource(R.mipmap.ic_restrained_false)
            }
            characterDAO.update(character)
        }

        holder.binding.stunnedImageView.setOnClickListener {
            character.stunned = !character.stunned
            onItemStunnedClickListener(position)
            if (character.stunned) {
                holder.binding.stunnedImageView.setImageResource(R.mipmap.ic_stunned)
            } else {
                holder.binding.stunnedImageView.setImageResource(R.mipmap.ic_stunned_false)
            }
            characterDAO.update(character)
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
            characterDAO.update(character)
        }
        val conditionImageViewMap = mapOf(
            Conditions.blinded to holder.binding.blindedImageView,
            Conditions.charmed to holder.binding.charmedImageView,
            Conditions.deafened to holder.binding.deafenedImageView,
            Conditions.exhausted to holder.binding.exhaustedImageView,
            Conditions.frightened to holder.binding.frightenedImageView,
            Conditions.grappled to holder.binding.grappledImageView,
            Conditions.incapacitated to holder.binding.incapacitatedImageView,
            Conditions.invisible to holder.binding.invisibleImageView,
            Conditions.paralyzed to holder.binding.paralyzedImageView,
            Conditions.petrified to holder.binding.petrifiedImageView,
            Conditions.poisoned to holder.binding.poisonedImageView,
            Conditions.prone to holder.binding.proneImageView,
            Conditions.restrained to holder.binding.restrainedImageView,
            Conditions.stunned to holder.binding.stunnedImageView,
            Conditions.unconscious to holder.binding.unconsciousImageView
        )

        for ((condition, imageView) in conditionImageViewMap) {
            setConditionLongClickListener(imageView, condition, position)
        }
    }
    override fun getItemCount(): Int = dataSet.size

    fun updateData(dataSet: List<Character>) {
        this.dataSet = dataSet.toMutableList()
        notifyDataSetChanged()
    }
    fun setCharacterImages(holder: CharacterViewHolder, character: Character) {
        // Define un diccionario de atributos y sus respectivas imágenes
        val attributeImageMap = mapOf(
            "blinded" to Pair(R.mipmap.ic_blinded, R.mipmap.ic_blinded_false),
            "charmed" to Pair(R.mipmap.ic_charmed, R.mipmap.ic_charmed_false),
            "deafened" to Pair(R.mipmap.ic_deafened, R.mipmap.ic_deafened_false),
            "exhausted" to Pair(R.mipmap.ic_exhausted, R.mipmap.ic_exhausted_false),
            "frightened" to Pair(R.mipmap.ic_frightened, R.mipmap.ic_frightened_false),
            "grappled" to Pair(R.mipmap.ic_grappled, R.mipmap.ic_grappled_false),
            "incapacitated" to Pair(R.mipmap.ic_incapacitated, R.mipmap.ic_incapacitated_false),
            "invisible" to Pair(R.mipmap.ic_invisible, R.mipmap.ic_invisible_false),
            "paralyzed" to Pair(R.mipmap.ic_paralyzed, R.mipmap.ic_paralyzed_false),
            "petrified" to Pair(R.mipmap.ic_petrified, R.mipmap.ic_petrified_false),
            "poisoned" to Pair(R.mipmap.ic_poisoned, R.mipmap.ic_poisoned_false),
            "prone" to Pair(R.mipmap.ic_prone, R.mipmap.ic_prone_false),
            "restrained" to Pair(R.mipmap.ic_restrained, R.mipmap.ic_restrained_false),
            "stunned" to Pair(R.mipmap.ic_stunned, R.mipmap.ic_stunned_false),
            "unconscious" to Pair(R.mipmap.ic_unconscious, R.mipmap.ic_unconscious_false)

            // Añade más atributos e imágenes según sea necesario
        )

        // Itera sobre el diccionario y aplica la lógica de if-else a cada atributo
        for ((attributeName, images) in attributeImageMap) {
            val imageView = when (attributeName) {
                "blinded" -> holder.binding.blindedImageView
                "charmed" -> holder.binding.charmedImageView
                "deafened" -> holder.binding.deafenedImageView
                "exhausted" -> holder.binding.exhaustedImageView
                "frightened" -> holder.binding.frightenedImageView
                "grappled" -> holder.binding.grappledImageView
                "incapacitated" -> holder.binding.incapacitatedImageView
                "invisible"-> holder.binding.invisibleImageView
                "paralyzed" -> holder.binding.paralyzedImageView
                "petrified" -> holder.binding.petrifiedImageView
                "poisoned"-> holder.binding.poisonedImageView
                "prone" -> holder.binding.proneImageView
                "restrained"-> holder.binding.restrainedImageView
                "stunned"-> holder.binding.stunnedImageView
                "unconscious"-> holder.binding.unconsciousImageView
                // Añade más ImageView según sea necesario
                else -> null
            }

            imageView?.let {
                val isAttributeTrue = when (attributeName) {
                    "blinded" -> character.blinded
                    "charmed" -> character.charmed
                    "deafened" -> character.deafened
                    "exhausted" -> character.exhausted
                    "frightened" -> character.frightened
                    "grappled" -> character.grappled
                    "incapacitated" -> character.incapacitated
                    "invisible"-> character.invisible
                    "paralyzed" -> character.paralyzed
                    "petrified" -> character.petrified
                    "poisoned"-> character.poisoned
                    "prone" -> character.prone
                    "restrained"-> character.restrained
                    "stunned"-> character.stunned
                    "unconscious"-> character.unconscious
                    // Añade más condiciones según los atributos
                    else -> false
                }

                val imageResource = if (isAttributeTrue) images.first else images.second
                it.setImageResource(imageResource)
            }
        }
    }
    private fun setConditionLongClickListener(
        imageView: ImageView,
        condition: Conditions,
        position: Int
    ) {
        imageView.setOnLongClickListener {
            val context = imageView.context
            val details = conditionDetails[condition]
            details?.let {
                val titleResId = it.first
                val descriptionResId = it.second
                val imageResId = it.third
                val inflater = LayoutInflater.from(context)
                val dialogView = inflater.inflate(R.layout.custom_view_layout, null)

                val titleTextView = dialogView.findViewById<TextView>(R.id.conditionTitleTextView)
                val descriptionTextView = dialogView.findViewById<TextView>(R.id.conditionDescriptionTextView)
                val conditionImageView = dialogView.findViewById<ImageView>(R.id.conditionImageView)

                titleTextView.text = context.getString(titleResId)
                descriptionTextView.text = context.getString(descriptionResId)
                conditionImageView.setImageResource(imageResId)

                AlertDialog.Builder(context)
                    .setView(dialogView)
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
            true
        }
    }

    class CharacterViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun render(character: Character, storedInitiative:Int) {
            binding.nameTextView.text = character.name
            binding.initTextview.text = character.initiative.toString()
            binding.hpTextview.text = character.hp.toString()
            // Mostrar la iniciativa almacenada en la sesión
            binding.finalInitTextview.text = storedInitiative.toString()
        }
    }

}private val conditionDetails = mapOf(
    Conditions.blinded to Triple(R.string.blinded_title_esp, R.string.blinded_description_esp, R.mipmap.ic_blinded),
    Conditions.charmed to Triple(R.string.charmed_title_esp, R.string.charmed_description_esp, R.mipmap.ic_charmed),
    Conditions.deafened to Triple(R.string.deafened_title_esp, R.string.deafened_description_esp, R.mipmap.ic_deafened),
    Conditions.exhausted to Triple(R.string.exhausted_title_esp, R.string.exhausted_description_esp, R.mipmap.ic_exhausted),
    Conditions.frightened to Triple(R.string.frightened_title_esp, R.string.frightened_description_esp, R.mipmap.ic_frightened),
    Conditions.grappled to Triple(R.string.grappled_title_esp, R.string.grappled_description_esp, R.mipmap.ic_grappled),
    Conditions.incapacitated to Triple(R.string.incapacitated_title_esp, R.string.incapacitated_description_esp, R.mipmap.ic_incapacitated),
    Conditions.invisible to Triple(R.string.invisible_title_esp, R.string.invisible_description_esp, R.mipmap.ic_invisible),
    Conditions.paralyzed to Triple(R.string.paralyzed_title_esp, R.string.paralyzed_description_esp, R.mipmap.ic_paralyzed),
    Conditions.petrified to Triple(R.string.petrified_title_esp, R.string.petrified_description_esp, R.mipmap.ic_petrified),
    Conditions.poisoned to Triple(R.string.poisoned_title_esp, R.string.poisoned_description_esp, R.mipmap.ic_poisoned),
    Conditions.prone to Triple(R.string.prone_title_esp, R.string.prone_description_esp, R.mipmap.ic_prone),
    Conditions.restrained to Triple(R.string.restrained_title_esp, R.string.restrained_description_esp, R.mipmap.ic_restrained),
    Conditions.stunned to Triple(R.string.stunned_title_esp, R.string.stunned_description_esp, R.mipmap.ic_stunned),
    Conditions.unconscious to Triple(R.string.unconscious_title_esp, R.string.unconscious_description_esp, R.mipmap.ic_unconscious)
)