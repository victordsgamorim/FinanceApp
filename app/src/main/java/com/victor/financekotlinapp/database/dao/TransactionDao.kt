package com.victor.financekotlinapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.victor.financekotlinapp.model.Transaction

@Dao
interface TransactionDao {

    @Insert
    fun add(transaction: Transaction)

    @Query("SELECT * FROM `Transaction` WHERE userId = :userId")
    fun get(userId: Long): LiveData<List<Transaction>?>
}