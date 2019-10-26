package com.victor.financekotlinapp.database.converter

import androidx.room.TypeConverter
import java.util.*

class CalendarConverter {


    @TypeConverter
    fun toLong(calendar: Calendar): Long {
        return calendar.timeInMillis
    }

    @TypeConverter
    fun toCalendar(date: Long?): Calendar {
        val calendar = Calendar.getInstance()

        date?.let {
            calendar.timeInMillis = it
        }

        return calendar

    }
}