package com.victor.financekotlinapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.victor.financekotlinapp.model.User
import com.victor.financekotlinapp.repository.TablayoutRepository
import com.victor.financekotlinapp.repository.UserRepository

class ChartIncomingFragmentViewModel(
    private val tablayoutRepository: TablayoutRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    fun getId(): Long {
        return tablayoutRepository.get()
    }

    fun getUserById(id: Long): LiveData<User?> {
        return userRepository.getUserById(id)
    }
}