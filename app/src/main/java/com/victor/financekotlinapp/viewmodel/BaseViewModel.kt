package com.victor.financekotlinapp.viewmodel

import androidx.lifecycle.ViewModel
import com.victor.financekotlinapp.model.Transaction
import com.victor.financekotlinapp.repository.TablayoutRepository
import com.victor.financekotlinapp.repository.TransactionRepository

abstract class BaseViewModel(
    tablayoutRepository: TablayoutRepository,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    val id: Long = tablayoutRepository.get()

    fun add(transaction: Transaction) {
        transactionRepository.add(transaction)
    }
}