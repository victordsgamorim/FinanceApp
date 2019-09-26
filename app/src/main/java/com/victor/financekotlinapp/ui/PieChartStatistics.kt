package com.victor.financekotlinapp.ui

import com.victor.financekotlinapp.model.Balance
import com.victor.financekotlinapp.model.BalanceType
import java.math.BigDecimal

class PieChartStatistics(private val transactions: List<Balance>) {

    fun sumOfBalanceIncoming(): Double {
        return transactions
            .filter { it.type == BalanceType.INCOMING }
            .sumByDouble { it.value.toDouble() }

    }

    fun sumOfBalanaceOutgoing(): Double {
        return transactions
            .filter { it.type == BalanceType.OUTGOING }
            .sumByDouble { it.value.toDouble() }
    }

    fun totalBalance(): BigDecimal {
        val total = sumOfBalanceIncoming().minus(sumOfBalanaceOutgoing())
        return BigDecimal(total)
    }

}