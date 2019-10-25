package com.victor.financekotlinapp.repository

import android.content.SharedPreferences
import androidx.core.content.edit

private const val USER_ID_KEY = "com.victor.financekotlinapp.repository.TablayoutRepository"

class TablayoutRepository(private val preferences: SharedPreferences) {

    fun save(id: Long) {
        saveUserState(id)
    }

    fun get(): Long {
        return preferences.getLong(USER_ID_KEY, -1)
    }

    private fun saveUserState(userId: Long) {
        preferences.edit {
            putLong(USER_ID_KEY, userId)
        }
    }
}