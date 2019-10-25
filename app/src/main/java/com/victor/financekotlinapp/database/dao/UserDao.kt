package com.victor.financekotlinapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.victor.financekotlinapp.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun add(use: User)

    @Query("SELECT * FROM User WHERE userName = :userName AND password = :password")
    suspend fun get(userName: String, password: String): User?

}
