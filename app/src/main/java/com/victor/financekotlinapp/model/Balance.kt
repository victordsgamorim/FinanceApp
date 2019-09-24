package com.victor.financekotlinapp.model

import java.math.BigDecimal
import java.util.*

class Balance(
    val message: String,
    val value: BigDecimal,
    val date: Calendar = Calendar.getInstance(),
    val type: BalanceType
)

