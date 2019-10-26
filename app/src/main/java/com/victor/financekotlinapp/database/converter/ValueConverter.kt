package com.victor.financekotlinapp.database.converter

import androidx.room.TypeConverter
import java.math.BigDecimal


class ValueConverter {

    @TypeConverter
    fun toDouble(value: BigDecimal): Double {
        return value.toDouble()
    }

    @TypeConverter
    fun toBigDecimal(value: Double): BigDecimal {
        return BigDecimal(value)
    }
}