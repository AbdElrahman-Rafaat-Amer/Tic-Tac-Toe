package com.abdelrahman.raafat.tictactoe

import android.content.Context
import android.content.SharedPreferences

object PreferencesManager {
    private const val PREFERENCES_NAME = "TIC_TAC_TOE_PREFERENCES"

    fun saveBoolean(context: Context, key: String, value: Boolean){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(context: Context, key: String, defaultValue: Boolean = false): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(key, defaultValue)
    }
}