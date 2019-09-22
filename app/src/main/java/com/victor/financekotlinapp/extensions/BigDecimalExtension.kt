package com.victor.financekotlinapp.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.formatCurrecyToCanada(): String {
    val format = NumberFormat.getCurrencyInstance(Locale.CANADA)
    return format.format(this)
}