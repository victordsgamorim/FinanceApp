package com.victor.financekotlinapp.repository

import androidx.lifecycle.LiveData
import com.victor.financekotlinapp.database.dao.TransactionDao
import com.victor.financekotlinapp.model.Transaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TransactionRepository(private val dao: TransactionDao) {

    fun add(transaction: Transaction) {
        CoroutineScope(IO).launch {
            dao.add(transaction)
        }
    }

    fun get(userId: Long): LiveData<List<Transaction>?> {
        return dao.get(userId)
    }
}