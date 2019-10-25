package com.victor.financekotlinapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.victor.financekotlinapp.database.dao.UserDao
import com.victor.financekotlinapp.model.User

@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        private lateinit var db: AppDatabase

        fun getInstance(context: Context): AppDatabase {
            if (::db.isInitialized) {
                return db
            }

            db = Room.databaseBuilder(context, AppDatabase::class.java, "finance.db")
                .addMigrations(object : Migration(1, 2) {
                    override fun migrate(database: SupportSQLiteDatabase) {
                        database.execSQL(
                            "CREATE TABLE IF NOT EXISTS `tempUser` " +
                                    "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                                    "`firstName` TEXT NOT NULL, " +
                                    "`surname` TEXT NOT NULL, " +
                                    "`userName` TEXT NOT NULL, " +
                                    "`password` TEXT NOT NULL)"
                        )

                        database.execSQL("INSERT INTO tempUser (id, firstName, surname, userName, password) " +
                                "SELECT id, firstName, surname, userName, password FROM User")

                        database.execSQL("DROP TABLE User")

                        database.execSQL("ALTER TABLE tempUser RENAME TO User")
                    }

                })
                .build()

            return db

        }
    }
}