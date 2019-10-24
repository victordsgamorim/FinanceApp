package com.victor.financekotlinapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val firstName: String?,
    val surname: String?,
    val userName: String?,
    val password: String?
)



