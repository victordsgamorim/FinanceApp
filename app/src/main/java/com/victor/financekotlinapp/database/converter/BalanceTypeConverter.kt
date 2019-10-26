package com.victor.financekotlinapp.database.converter

import androidx.room.TypeConverter
import com.victor.financekotlinapp.model.BalanceType

class BalanceTypeConverter {

    @TypeConverter
    fun toString(type: BalanceType): String {
        return type.name
    }

    @TypeConverter
    fun toBalanceType(type: String): BalanceType {
        return BalanceType.valueOf(type)
    }
}