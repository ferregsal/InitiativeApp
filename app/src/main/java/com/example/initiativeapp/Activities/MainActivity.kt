package com.example.initiativeapp.Activities

import android.content.Intent
import android.os.Bundle
import android.provider.BaseColumns
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopeapp.utils.SessionManager
import com.example.initiativeapp.Adapters.CharacterAdapter
import com.example.initiativeapp.Data.Character
import com.example.initiativeapp.Data.CharacterDAO
import com.example.initiativeapp.R
import com.example.initiativeapp.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var characterRecyclerView: RecyclerView
    private lateinit var characterAdapter: CharacterAdapter
    lateinit var characterList: List<Character>
    lateinit var characterDAO: CharacterDAO
    lateinit var session:SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {

        session = SessionManager(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        characterRecyclerView = binding.recyclerView

        val rollDiceButton = binding.rollDiceButton

        rollDiceButton.setOnClickListener {
            // Ejecutar la animación al pulsar el botón
            val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            rollDiceButton.startAnimation(rotateAnimation)

            // Generar un número aleatorio para cada personaje y actualizar su iniciativa
            characterList.forEach { character ->
                val roll = rollInitiative()
                val newInitiative = character.initiative + roll
                session.saveInitiative(character.id, newInitiative) // Guardar el nuevo valor en el SessionManager
                Toast.makeText(this, "${character.name}'s roll: ${roll}", Toast.LENGTH_SHORT).show()
            }

            // Actualizar datos en el adaptador (opcional si `sortByInitiative` ya notifica cambios)
            characterAdapter.updateData(characterList)
        }

        characterDAO = CharacterDAO(this)
        characterList = characterDAO.findAll()


        characterAdapter = CharacterAdapter(emptyList(), {
            characterDAO.delete(characterList[it])
            Toast.makeText(this, "Character Deleted Successfully", Toast.LENGTH_SHORT).show()
            loadData()
        },{position ->
            navigateToDetail(characterList[position])
            characterDAO.update(characterList[position])
        },{position->
          val character = characterList[position]
            character.hp = character.hp?.plus(1)
            characterDAO.update(character)
            loadData()
        }, {position->
            val character = characterList[position]
            character.hp = character.hp?.minus(1)
            characterDAO.update(character)
            loadData()
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },{
        },characterDAO = characterDAO)
        binding.recyclerView.adapter = characterAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()

        characterList = characterDAO.findAll()

        characterAdapter.updateData(characterList)
    }
    private fun loadData() {
        characterList = characterDAO.findAll()

        characterAdapter.updateData(characterList)
    }

    fun navigateToDetail(character: Character) {
        val intent = Intent(this, CreateEditActivity::class.java)
        intent.putExtra(BaseColumns._ID, character.id)
        startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.characterAddButton -> {
                val intent = Intent(this, CreateEditActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
    fun rollInitiative():Int{
        return Random.nextInt(1, 21)
    }

}
