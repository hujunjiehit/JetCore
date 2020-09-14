package com.junehit.app.di

import com.junehit.app.MainViewModel
import com.junehit.app.SecondViewModel
import com.junehit.app.adapter.DataAdapter
import com.junehit.app.fragment.TestRespository
import com.junehit.app.fragment.TestViewModel
import com.junehit.app.network.ApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 *Created by june
 *on 2020/9/14
 */

val appApiServiceModule = module {
    factory {
        get<Retrofit>().create(ApiService::class.java)
    }

    factory {
        DataAdapter()
    }
}

val appRepoModule = module {
    single {
        TestRespository(get())
    }
}

val appViewModelModule = module {
    viewModel { TestViewModel(get()) }

    viewModel { MainViewModel() }

    viewModel { SecondViewModel() }
}