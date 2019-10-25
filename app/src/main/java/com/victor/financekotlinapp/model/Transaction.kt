package com.victor.financekotlinapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onUpdate = CASCADE,
            onDelete = CASCADE
        )],
    indices = [
        Index("userId")]
)


class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val message: String,
    val value: BigDecimal,
    val date: Calendar = Calendar.getInstance(),
    val type: BalanceType,
    val userId: Long
)



