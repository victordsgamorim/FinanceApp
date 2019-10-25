package com.victor.financekotlinapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.victor.financekotlinapp.repository.UserRepository
import com.victor.financekotlinapp.viewmodel.LoginFragmentViewModel

class LoginFragmentViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginFragmentViewModel(repository) as T
    }
}