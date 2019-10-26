package com.victor.financekotlinapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.victor.financekotlinapp.database.converter.BalanceTypeConverter
import com.victor.financekotlinapp.database.converter.CalendarConverter
import com.victor.financekotlinapp.database.converter.ValueConverter
import com.victor.financekotlinapp.database.dao.TransactionDao
import com.victor.financekotlinapp.database.dao.UserDao
import com.victor.financekotlinapp.model.User

@Database(
    entities = [User::class, com.victor.financekotlinapp.model.Transaction::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ValueConverter::class, CalendarConverter::class, BalanceTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getTransactionDao(): TransactionDao
}