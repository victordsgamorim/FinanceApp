package com.victor.financekotlinapp.viewmodel

import androidx.lifecycle.ViewModel
import com.victor.financekotlinapp.repository.TablayoutRepository

class TablayoutFragmentViewModel(private val repository: TablayoutRepository) : ViewModel() {

    fun save(userId: Long) {
        repository.save(userId)
    }
}