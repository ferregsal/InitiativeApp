package com.example.initiativeapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.initiativeapp.Adapters.CharacterAdapter
import com.example.initiativeapp.Data.Character
import com.example.initiativeapp.R

class MainActivity : AppCompatActivity() {
    lateinit var character : Character
    private var characterList: List<Character> = CharacterProvider.characterList
    lateinit var recyclerView: RecyclerView
    /*lateinit var filterFuegoSwitch: Switch
    lateinit var filterAireSwitch: Switch
    lateinit var filterAguaSwitch: Switch
    lateinit var filterTierraSwitch: Switch*/
    lateinit var session: SessionManager

    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        session = SessionManager(this)
        characterList = CharacterProvider.findAll()
        recyclerView = findViewById(R.id.recyclerView)
       /* filterFuegoSwitch = findViewById(R.id.filterFuegoSwitch)
        filterAireSwitch = findViewById(R.id.filterAireSwitch)
        filterAguaSwitch = findViewById(R.id.filterAguaSwitch)
        filterTierraSwitch = findViewById(R.id.filterTierraSwitch)*/

        adapter = CharacterAdapter(characterList) { position ->
            navigateToDetail(characterList[position])
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        //recyclerView.setBackgroundColor(Horoscope.color)
        setupSwitchListeners()

    }
    override fun onResume() {
        super.onResume()
        adapter.updateData(characterList)
    }

}
}