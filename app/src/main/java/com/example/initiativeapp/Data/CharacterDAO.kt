package com.example.initiativeapp.Data

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import com.example.initiativeapp.Data.Character
import com.example.initiativeapp.Utils.DatabaseManager

class CharacterDAO(context: Context) {
    private val DatabaseManager: DatabaseManager = DatabaseManager(context)

    fun insert(character: Character) {
        val db = DatabaseManager.writableDatabase

        val values = ContentValues()
        values.put(Character.COLUMN_NAME_NAME, character.name)
        values.put(Character.COLUMN_NAME_INITIATIVE, character.initiative)
        values.put(Character.COLUMN_NAME_HP, character.hp)

        val newRowId = db.insert(Character.TABLE_NAME, null, values)
        character.id = newRowId.toInt()
    }

    fun update(character: Character) {
        val db = DatabaseManager.writableDatabase

        val values = ContentValues()
        values.put(Character.COLUMN_NAME_NAME, character.name)
        values.put(Character.COLUMN_NAME_INITIATIVE, character.initiative)
        values.put(Character.COLUMN_NAME_HP, character.hp)
        values.put(Character.COLUMN_NAME_BLINDED, character.name)
        values.put(Character.COLUMN_NAME_CHARMED, character.charmed)
        values.put(Character.COLUMN_NAME_DEAFENED, character.deafened)
        values.put(Character.COLUMN_NAME_FRIGHTENED, character.frightened)
        values.put(Character.COLUMN_NAME_GRAPPLED, character.grappled)
        values.put(Character.COLUMN_NAME_INCAPACITATED, character.incapacitated)
        values.put(Character.COLUMN_NAME_INVISIBLE, character.invisible)
        values.put(Character.COLUMN_NAME_PARALYZED, character.paralyzed)
        values.put(Character.COLUMN_NAME_PETRIFIED, character.petrified)
        values.put(Character.COLUMN_NAME_POISONED, character.poisoned)
        values.put(Character.COLUMN_NAME_PRONE, character.prone)
        values.put(Character.COLUMN_NAME_RESTRAINED, character.restrained)
        values.put(Character.COLUMN_NAME_STUNNED, character.stunned)
        values.put(Character.COLUMN_NAME_UNCONSCIOUS, character.unconscious)
        values.put(Character.COLUMN_NAME_EXHAUSTED, character.exhausted)
        val updatedRows = db.update(
            Character.TABLE_NAME,
            values,
            "${BaseColumns._ID} = ${character.id}",
            null
        )
    }

    fun delete(character: Character) {
        val db = DatabaseManager.writableDatabase

        val deletedRows =
            db.delete(Character.TABLE_NAME, "${BaseColumns._ID} = ${character.id}", null)
    }

    fun find(id: Int): Character? {
        val db = DatabaseManager.readableDatabase

        val projection = arrayOf(
            BaseColumns._ID,
            Character.COLUMN_NAME_NAME,
            Character.COLUMN_NAME_INITIATIVE,
            Character.COLUMN_NAME_HP,
            Character.COLUMN_NAME_BLINDED,
            Character.COLUMN_NAME_CHARMED,
            Character.COLUMN_NAME_DEAFENED,
            Character.COLUMN_NAME_FRIGHTENED,
            Character.COLUMN_NAME_GRAPPLED,
            Character.COLUMN_NAME_INCAPACITATED,
            Character.COLUMN_NAME_INVISIBLE,
            Character.COLUMN_NAME_PARALYZED,
            Character.COLUMN_NAME_PETRIFIED,
            Character.COLUMN_NAME_POISONED,
            Character.COLUMN_NAME_PRONE,
            Character.COLUMN_NAME_RESTRAINED,
            Character.COLUMN_NAME_STUNNED,
            Character.COLUMN_NAME_UNCONSCIOUS,
            Character.COLUMN_NAME_EXHAUSTED
        )

        val cursor = db.query(
            Character.TABLE_NAME,                        // The table to query
            projection,                             // The array of columns to return (pass null to get all)
            "${BaseColumns._ID} = $id",      // The columns for the WHERE clause
            null,                         // The values for the WHERE clause
            null,                            // don't group the rows
            null,                             // don't filter by row groups
            null                       // The sort order
        )

        var character: Character? = null
        if (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(BaseColumns._ID))
            val name = cursor.getString(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_NAME))
            val initiative = cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_INITIATIVE))
            val hp = cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_HP))
            val blinded= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_BLINDED)) ==1
            val charmed= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_CHARMED)) ==1
            val deafened= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_DEAFENED)) ==1
            val frightened= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_FRIGHTENED)) ==1
            val grappled= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_GRAPPLED)) ==1
            val incapacitated= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_INCAPACITATED)) ==1
            val invisible= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_INVISIBLE)) ==1
            val paralyzed= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_PARALYZED)) ==1
            val petrified= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_PETRIFIED)) ==1
            val poisoned= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_POISONED)) ==1
            val prone= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_PRONE)) ==1
            val restrained= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_RESTRAINED)) ==1
            val stunned= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_STUNNED)) ==1
            val unconscious= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_UNCONSCIOUS)) ==1
            val exhausted= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_EXHAUSTED)) ==1

            character = Character(id, name, initiative, hp, blinded, charmed, deafened, frightened, grappled, incapacitated, invisible, paralyzed, petrified, poisoned, prone, restrained, stunned, unconscious, exhausted)
        }
        cursor.close()
        db.close()
        return character
    }

    fun findAll(): List<Character> {
        val db = DatabaseManager.readableDatabase

        val projection =
            arrayOf( BaseColumns._ID,
                Character.COLUMN_NAME_NAME,
                Character.COLUMN_NAME_INITIATIVE,
                Character.COLUMN_NAME_HP,
                Character.COLUMN_NAME_BLINDED,
                Character.COLUMN_NAME_CHARMED,
                Character.COLUMN_NAME_DEAFENED,
                Character.COLUMN_NAME_FRIGHTENED,
                Character.COLUMN_NAME_GRAPPLED,
                Character.COLUMN_NAME_INCAPACITATED,
                Character.COLUMN_NAME_INVISIBLE,
                Character.COLUMN_NAME_PARALYZED,
                Character.COLUMN_NAME_PETRIFIED,
                Character.COLUMN_NAME_POISONED,
                Character.COLUMN_NAME_PRONE,
                Character.COLUMN_NAME_RESTRAINED,
                Character.COLUMN_NAME_STUNNED,
                Character.COLUMN_NAME_UNCONSCIOUS,
                Character.COLUMN_NAME_EXHAUSTED)

        val cursor = db.query(
            Character.TABLE_NAME,                        // The table to query
            projection,                             // The array of columns to return (pass null to get all)
            null,                            // The columns for the WHERE clause
            null,                         // The values for the WHERE clause
            null,                            // don't group the rows
            null,                             // don't filter by row groups
            null                           // The sort order
        )

        var characters = mutableListOf<Character>()
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(BaseColumns._ID))
            val name = cursor.getString(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_NAME))
            val initiative = cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_INITIATIVE))
            val hp = cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_HP))
            val blinded= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_BLINDED)) ==1
            val charmed= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_CHARMED)) ==1
            val deafened= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_DEAFENED)) ==1
            val frightened= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_FRIGHTENED)) ==1
            val grappled= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_GRAPPLED)) ==1
            val incapacitated= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_INCAPACITATED)) ==1
            val invisible= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_INVISIBLE)) ==1
            val paralyzed= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_PARALYZED)) ==1
            val petrified= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_PETRIFIED)) ==1
            val poisoned= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_POISONED)) ==1
            val prone= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_PRONE)) ==1
            val restrained= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_RESTRAINED)) ==1
            val stunned= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_STUNNED)) ==1
            val unconscious= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_UNCONSCIOUS)) ==1
            val exhausted= cursor.getInt(cursor.getColumnIndexOrThrow(Character.COLUMN_NAME_EXHAUSTED)) ==1


            val character = Character(id, name, initiative, hp, blinded, charmed, deafened, frightened, grappled, incapacitated, invisible, paralyzed, petrified, poisoned, prone, restrained, stunned, unconscious, exhausted)
            characters.add(character)
        }
        cursor.close()
        db.close()
        return characters
    }
}

