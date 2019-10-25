package com.victor.financekotlinapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun get(userName: String, password: String): LiveData<User> {

        val getFoundUser = MutableLiveData<User>()

        CoroutineScope(IO).launch {
            val user = dao.get(userName, password)

            withContext(Main) {
                getFoundUser.value = user
            }
        }

        return getFoundUser
    }


}