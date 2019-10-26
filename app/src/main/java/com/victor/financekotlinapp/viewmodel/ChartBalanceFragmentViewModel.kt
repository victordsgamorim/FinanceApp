package com.victor.financekotlinapp.viewmodel

import androidx.lifecycle.LiveData
import com.victor.financekotlinapp.model.Transaction
import com.victor.financekotlinapp.repository.TablayoutRepository
import com.victor.financekotlinapp.repository.TransactionRepository

class ChartBalanceFragmentViewModel(
    tablayoutRepository: TablayoutRepository,
    private val transactionRepository: TransactionRepository
) : BaseViewModel(tablayoutRepository, transactionRepository) {


    fun getList(userId: Long): LiveData<List<Transaction>?> {
        return transactionRepository.get(userId)
    }
}
