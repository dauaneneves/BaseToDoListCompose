package br.edu.satc.todolistcompose.ui.theme

import android.content.Context
import android.content.SharedPreferences

class ThemePreferences(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences("theme_prefs", Context.MODE_PRIVATE)

    fun getTheme(): Boolean {
        return preferences.getBoolean("dark_theme", false)
    }

    fun setTheme(isDark: Boolean) {
        preferences.edit().putBoolean("dark_theme", isDark).apply()
    }
}