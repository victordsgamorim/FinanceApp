package com.victor.financekotlinapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.victor.financekotlinapp.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun add(use: User)

    @Query("SELECT * FROM User WHERE userName = :userName AND password = :password")
    fun get(userName: String, password: String): LiveData<User?>

    @Query("SELECT * FROM User WHERE id = :userId")
    fun get(userId: Long): LiveData<User?>

}
