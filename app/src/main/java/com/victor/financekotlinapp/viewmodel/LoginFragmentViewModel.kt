package com.victor.financekotlinapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.victor.financekotlinapp.model.User
import com.victor.financekotlinapp.repository.UserRepository

class LoginFragmentViewModel(private val repository: UserRepository) : ViewModel() {

    fun get(usename: String, password: String): LiveData<User> {
        return repository.get(usename, password)
    }
}