package com.victor.financekotlinapp.viewmodel

import androidx.lifecycle.ViewModel
import com.victor.financekotlinapp.model.User
import com.victor.financekotlinapp.repository.UserRepository

class SignUpViewFragmentModel(private val repository: UserRepository) : ViewModel() {

    fun add(user: User) {
        repository.add(user)
    }
}