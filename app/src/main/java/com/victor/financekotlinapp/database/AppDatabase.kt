package com.victor.financekotlinapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.victor.financekotlinapp.database.dao.UserDao
import com.victor.financekotlinapp.model.User

@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}