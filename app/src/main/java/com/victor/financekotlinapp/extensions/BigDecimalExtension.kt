package com.victor.financekotlinapp.extensions

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formatCurrecytToEuro(): String {
    val format = DecimalFormat.getCurrencyInstance(Locale.GERMANY)
    return format.format(this)
}

fun String.formatValueToNegative(): String {
    return "- $this"
}

fun String.formatValueToPositive(): String {
    return "+ $this"
}