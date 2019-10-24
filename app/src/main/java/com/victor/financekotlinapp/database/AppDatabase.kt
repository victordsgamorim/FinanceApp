package com.victor.financekotlinapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.victor.financekotlinapp.database.dao.UserDao
import com.victor.financekotlinapp.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        private lateinit var db: AppDatabase

        fun getInstance(context: Context): AppDatabase {
            if (::db.isInitialized) {
                return db
            }

            db = Room.databaseBuilder(context, AppDatabase::class.java, "finance.db")
                .allowMainThreadQueries()
                .build()

            return db

        }
    }
}