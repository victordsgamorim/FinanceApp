package com.victor.financekotlinapp.ui.adapter.config

import android.content.Context
import androidx.core.content.ContextCompat
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.formatCurrecytToEuro
import com.victor.financekotlinapp.extensions.formatDateToDDMMYYYY
import com.victor.financekotlinapp.extensions.trimBigMessage
import com.victor.financekotlinapp.model.Balance
import com.victor.financekotlinapp.model.BalanceType

class BalanceDesignConfig(
    private val balance: Balance,
    context: Context
) {

    private val type = balance.type
    private val colourMoneyInt = ContextCompat.getColor(context, R.color.moneyIn)
    private var colourMoneyOut = ContextCompat.getColor(context, R.color.moneyOut)
    private val iconArrowUp = R.drawable.ic_transaction_incoming
    private val iconArrowDown = R.drawable.ic_transaction_outgoing

    private val MAX_MESSAGE_CHARACTERS = 14

    val message = balance.message.trimBigMessage(MAX_MESSAGE_CHARACTERS)
    val date = balance.date.formatDateToDDMMYYYY()

    fun getValueColour(): Int {
        if (type == BalanceType.INCOMING) {
            return colourMoneyInt
        }
        return colourMoneyOut

    }

    fun getIcon(): Int {
        if (type == BalanceType.INCOMING) {
            return iconArrowUp
        }
        return iconArrowDown
    }

    fun getValueSign(): String {
        val value = balance.value.formatCurrecytToEuro()
        if (balance.type == BalanceType.INCOMING) {
            return "+ $value"
        }
        return "- $value"
    }


}