package com.example.data.storage

import android.content.Context

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_FIRST_NAME, user.firstName).apply()
        editor.putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, "def_first_name") ?: "def_first_name"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "") ?: "def_last_name"
        return User(firstName, lastName)
    }
}