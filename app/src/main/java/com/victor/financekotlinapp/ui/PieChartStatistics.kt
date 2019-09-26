package com.victor.financekotlinapp.ui

import com.victor.financekotlinapp.model.Balance
import com.victor.financekotlinapp.model.BalanceType

class PieChartStatistics(private val transaction: List<Balance>) {

    fun sumOfBalanceIncoming(): Double {
        return transaction
            .filter { it.type == BalanceType.INCOMING }
            .sumByDouble { it.value.toDouble() }
    }

    fun sumOfBalanaceOutgoing(): Double {
        return transaction
            .filter { it.type == BalanceType.OUTGOING }
            .sumByDouble { it.value.toDouble() }
    }

}