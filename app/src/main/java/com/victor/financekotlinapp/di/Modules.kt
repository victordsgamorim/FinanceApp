package com.victor.financekotlinapp.di

import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.view.ViewGroup
import androidx.room.Room
import com.victor.financekotlinapp.database.AppDatabase
import com.victor.financekotlinapp.database.dao.UserDao
import com.victor.financekotlinapp.repository.TablayoutRepository
import com.victor.financekotlinapp.repository.UserRepository
import com.victor.financekotlinapp.ui.adapter.TransactionAdapter
import com.victor.financekotlinapp.viewmodel.ChartIncomingFragmentViewModel
import com.victor.financekotlinapp.viewmodel.LoginFragmentViewModel
import com.victor.financekotlinapp.viewmodel.SignUpViewFragmentModel
import com.victor.financekotlinapp.viewmodel.TablayoutFragmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {

    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "finance.db"
        ).build()
    }


    single<TransactionAdapter> { TransactionAdapter(get()) }

    single<UserDao> { get<AppDatabase>().getUserDao() }
    single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(get()) }

    single<UserRepository> { UserRepository(get()) }
    single<TablayoutRepository> { TablayoutRepository(get()) }

    viewModel<LoginFragmentViewModel> { LoginFragmentViewModel(get()) }
    viewModel<SignUpViewFragmentModel> { SignUpViewFragmentModel(get()) }
    viewModel<TablayoutFragmentViewModel> { TablayoutFragmentViewModel(get()) }
    viewModel<ChartIncomingFragmentViewModel> { ChartIncomingFragmentViewModel(get(), get()) }

}