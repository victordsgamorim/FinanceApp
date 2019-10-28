package com.victor.financekotlinapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.victor.financekotlinapp.model.User
import com.victor.financekotlinapp.repository.TablayoutRepository
import com.victor.financekotlinapp.repository.UserRepository

class TablayoutFragmentViewModel(
    private val repository: TablayoutRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    fun save(userId: Long) {
        repository.save(userId)
    }

    fun getUser(userId: Long): LiveData<User?> {
        return userRepository.getUserById(userId)
    }
}