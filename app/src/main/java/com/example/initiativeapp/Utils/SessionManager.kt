package com.example.horoscopeapp.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE)

    fun saveInitiative(characterId: Int, initiative: Int) {
        val editor = prefs.edit()
        editor.putInt("final_initiative_$characterId", initiative)
        editor.apply()
    }

    fun getInitiative(characterId: Int): Int {
        return prefs.getInt("final_initiative_$characterId", 0)
    }

}