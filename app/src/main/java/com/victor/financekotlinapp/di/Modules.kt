package com.victor.financekotlinapp.di

import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import com.victor.financekotlinapp.database.AppDatabase
import com.victor.financekotlinapp.database.dao.TransactionDao
import com.victor.financekotlinapp.database.dao.UserDao
import com.victor.financekotlinapp.repository.TablayoutRepository
import com.victor.financekotlinapp.repository.TransactionRepository
import com.victor.financekotlinapp.repository.UserRepository
import com.victor.financekotlinapp.ui.adapter.TransactionAdapter
import com.victor.financekotlinapp.viewmodel.*
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
    single<TransactionDao> { get<AppDatabase>().getTransactionDao() }
    single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(get()) }

    single<UserRepository> { UserRepository(get()) }
    single<TablayoutRepository> { TablayoutRepository(get()) }
    single<TransactionRepository> { TransactionRepository(get()) }

    viewModel<LoginFragmentViewModel> { LoginFragmentViewModel(get()) }
    viewModel<SignUpViewFragmentModel> { SignUpViewFragmentModel(get()) }
    viewModel<TablayoutFragmentViewModel> { TablayoutFragmentViewModel(get()) }
    viewModel<ChartIncomingFragmentViewModel> { ChartIncomingFragmentViewModel(get(), get()) }
    viewModel<ChartBalanceFragmentViewModel> { ChartBalanceFragmentViewModel(get(), get()) }

}