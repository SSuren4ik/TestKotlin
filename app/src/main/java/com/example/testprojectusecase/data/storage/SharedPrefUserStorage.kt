package com.example.testprojectusecase.data.storage

import android.content.Context
import com.example.testprojectusecase.domain.models.SaveUserNameParam
import com.example.testprojectusecase.domain.models.UserName

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(saveParam: SaveUserNameParam): Boolean {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_FIRST_NAME, saveParam.firstName).apply()
        editor.putString(KEY_LAST_NAME, saveParam.lastName).apply()
        return true
    }

    override fun get(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "def_first_name") ?: "def_first_name"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "")?: "def_last_name"
        return UserName(firstName, lastName)
    }
}