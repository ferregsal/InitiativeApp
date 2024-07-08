package com.example.initiativeapp.Data
import android.provider.BaseColumns

data class Character(
    var id: Int,
    var name: String,
    var initiative: Int,
    var hp: Int?,
    var blinded: Boolean =false,
    var charmed: Boolean =false,
    var deafened: Boolean=false,
    var frightened: Boolean=false,
    var grappled: Boolean=false,
    var incapacitated: Boolean=false,
    var invisible: Boolean=false,
    var paralyzed: Boolean=false,
    var petrified: Boolean=false,
    var poisoned: Boolean=false,
    var prone: Boolean=false,
    var restrained: Boolean=false,
    var stunned: Boolean=false,
    var unconscious: Boolean=false,
    var exhausted: Boolean=false
    ) {

    companion object {
        const val TABLE_NAME = "Characters"
        const val COLUMN_NAME_NAME = "Name"
        const val COLUMN_NAME_INITIATIVE = "Initiative"
        const val COLUMN_NAME_HP = "HP"
        const val COLUMN_NAME_BLINDED = "Blinded"
        const val COLUMN_NAME_CHARMED = "Charmed"
        const val COLUMN_NAME_DEAFENED = "Deafened"
        const val COLUMN_NAME_FRIGHTENED = "Frightened"
        const val COLUMN_NAME_GRAPPLED = "Grappled"
        const val COLUMN_NAME_INCAPACITATED = "Incapacitated"
        const val COLUMN_NAME_INVISIBLE = "Invisible"
        const val COLUMN_NAME_PARALYZED = "Paralyzed"
        const val COLUMN_NAME_PETRIFIED = "Petrified"
        const val COLUMN_NAME_POISONED = "Poisoned"
        const val COLUMN_NAME_PRONE = "Prone"
        const val COLUMN_NAME_RESTRAINED = "Restrained"
        const val COLUMN_NAME_STUNNED = "Stunned"
        const val COLUMN_NAME_UNCONSCIOUS = "Unconscious"
        const val COLUMN_NAME_EXHAUSTED = "Exhausted"
        const val SQL_CREATE_TABLE =
            "CREATE TABLE $TABLE_NAME (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME_NAME TEXT," +
                    "$COLUMN_NAME_INITIATIVE INTEGER," +
                    "$COLUMN_NAME_HP INTEGER," +
                    "$COLUMN_NAME_BLINDED BOOLEAN," +
                    "$COLUMN_NAME_CHARMED BOOLEAN," +
                    "$COLUMN_NAME_DEAFENED BOOLEAN," +
                    "$COLUMN_NAME_FRIGHTENED BOOLEAN," +
                    "$COLUMN_NAME_GRAPPLED BOOLEAN," +
                    "$COLUMN_NAME_INCAPACITATED BOOLEAN," +
                    "$COLUMN_NAME_INVISIBLE BOOLEAN," +
                    "$COLUMN_NAME_PARALYZED BOOLEAN," +
                    "$COLUMN_NAME_PETRIFIED BOOLEAN," +
                    "$COLUMN_NAME_POISONED BOOLEAN," +
                    "$COLUMN_NAME_PRONE BOOLEAN," +
                    "$COLUMN_NAME_RESTRAINED BOOLEAN," +
                    "$COLUMN_NAME_STUNNED BOOLEAN," +
                    "$COLUMN_NAME_UNCONSCIOUS BOOLEAN,"+
                    "$COLUMN_NAME_EXHAUSTED BOOLEAN)"

        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

}

