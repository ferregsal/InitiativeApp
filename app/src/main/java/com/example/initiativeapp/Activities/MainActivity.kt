package com.example.initiativeapp.Activities




import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.view.Menu
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.initiativeapp.R
import com.example.initiativeapp.Adapters.CharacterAdapter
import com.example.initiativeapp.Data.Character
import com.example.initiativeapp.Data.CharacterDAO
import com.example.initiativeapp.databinding.ActivityMainBinding

import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var characterRecyclerView: RecyclerView
    lateinit var addCategoryButton: FloatingActionButton
    private lateinit var characterAdapter: CharacterAdapter
    lateinit var characterList: List<Character>
    lateinit var characterDAO: CharacterDAO
    var searchText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        characterRecyclerView = binding.recyclerView

        addCategoryButton = binding.characterAddButton


        characterDAO = CharacterDAO(this)
        characterList = characterDAO.findAll()


        characterAdapter = CharacterAdapter(emptyList(), {position ->


            // showAlertDialog()
        // Toast.makeText(this, "Click on Character ${characterList[position].name}", Toast.LENGTH_SHORT).show()


        }, { position, newCharacterName ->
            val character = characterList[position]
            character.name = newCharacterName
            characterDAO.update(character)
            loadData()
        }, {
            characterDAO.delete(characterList[it])
            Toast.makeText(this, "Character Deleted Successfully", Toast.LENGTH_SHORT).show()
            loadData()
        }, {position ->
            navigateToDetail(characterList[position])
            /*characterDAO.update(characterList[position])
            Toast.makeText(this, "Character Edit Successfully Clicked", Toast.LENGTH_SHORT).show()
            loadData()*/
        }, {position->
          val character = characterList[position]
            character.hp = character.hp?.plus(1)
            characterDAO.update(character)
            loadData()
        }, {position->
            val character = characterList[position]
            character.hp = character.hp?.minus(1)
            characterDAO.update(character)
            loadData()
        },{position->
          val character = characterList[position]
            character.blinded = !character.blinded

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

        })
        binding.recyclerView.adapter = characterAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.characterAddButton.setOnClickListener {
            val intent = Intent(this, CreateEditActivity::class.java)
            startActivity(intent)
        }

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
}
