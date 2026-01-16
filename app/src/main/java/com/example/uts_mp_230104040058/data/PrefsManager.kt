package com.example.uts_mp_230104040058.data

import android.content.Context
import android.content.SharedPreferences

class  PrefsManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("uts_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_USERNAME = "key_username"
    }

    fun saveUsername(username: String) {
        prefs.edit().putString(KEY_USERNAME, username).apply()
    }

    fun getUsername(): String? = prefs.getString(KEY_USERNAME, null)

    fun clearUsername() {
        prefs.edit().remove(KEY_USERNAME).apply()
    }
}
