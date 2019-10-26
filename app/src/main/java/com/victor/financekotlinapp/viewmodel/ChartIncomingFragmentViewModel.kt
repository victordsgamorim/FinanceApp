package com.victor.financekotlinapp.viewmodel

import com.victor.financekotlinapp.repository.TablayoutRepository
import com.victor.financekotlinapp.repository.TransactionRepository

class ChartIncomingFragmentViewModel(
    tablayoutRepository: TablayoutRepository,
    transactionRepository: TransactionRepository
) : BaseViewModel(tablayoutRepository, transactionRepository)

