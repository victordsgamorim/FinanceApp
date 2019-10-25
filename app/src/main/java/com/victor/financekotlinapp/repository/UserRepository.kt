package com.victor.financekotlinapp.repository

import com.victor.financekotlinapp.database.dao.UserDao
import com.victor.financekotlinapp.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepository(private val dao: UserDao) {

    fun add(user: User) {
        CoroutineScope(IO).launch {
            dao.add(user)
        }
    }

    fun get(userName: String, password: String, onFinish: (user: User?) -> Unit) {
        CoroutineScope(IO).launch {
            val user = dao.get(userName, password)

            withContext(Main) {
                onFinish(user)
            }
        }
    }


}