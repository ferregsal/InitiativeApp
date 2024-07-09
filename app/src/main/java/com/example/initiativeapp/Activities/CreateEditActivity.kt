package com.example.initiativeapp.Activities



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.Toast
import com.example.initiativeapp.Data.Character
import com.example.initiativeapp.Data.CharacterDAO
import com.example.initiativeapp.databinding.ActivityCreateEditBinding
import kotlin.math.log


class CreateEditActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCreateEditBinding

    private lateinit var characterDAO: CharacterDAO

    private var characterId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        characterDAO = CharacterDAO(this)
        characterId = intent.getIntExtra(BaseColumns._ID, -1)

        if (characterId != -1) {
            // Editar
            val editingCharacter = characterDAO.findById(characterId)!!
            Log.i("id", editingCharacter.name)
            Log.i("id", editingCharacter.initiative.toString())
            Log.i("id", editingCharacter.hp.toString())
            binding.characterEditText.setText(editingCharacter.name)
            binding.initiativeEditText.setText(editingCharacter.initiative.toString())
            binding.hpEditText.setText(editingCharacter.hp.toString())
            binding.newCharacterButton.setOnClickListener {
            editingCharacter.name = binding.characterEditText.text.toString()
            editingCharacter.initiative = binding.initiativeEditText.text.toString().toInt()
            editingCharacter.hp = binding.hpEditText.text.toString().toInt()
            characterDAO.update(editingCharacter)
            Toast.makeText(this, "Character Edited correctly", Toast.LENGTH_SHORT).show()
            finish()
            }

        } else {
            // Crear
            binding.newCharacterButton.setOnClickListener {
                val characterName = binding.characterEditText.text.toString()
                val characterInitiative = binding.initiativeEditText.text.toString()
                val characterHp = binding.hpEditText.text.toString()
                val character = Character(-1, characterName, characterInitiative.toInt(),characterHp.toInt())
                characterDAO.insert(character)
                Toast.makeText(this, "Character saved correctly", Toast.LENGTH_SHORT).show()
                finish()
            }

        }




    }
}