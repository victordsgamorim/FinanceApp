package com.victor.financekotlinapp.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formatToNormalData(): String {

    var format = SimpleDateFormat("dd/MM/yyyy")
    return format.format(this.time)
}