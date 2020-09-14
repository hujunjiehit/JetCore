package com.junehit.login.di

import com.junehit.login.LoginViewModel
import com.junehit.login.network.LoginApiService
import com.junehit.login.repository.LoginRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 *Created by june
 *on 2020/9/14
 */

val loginApiServiceModule = module {
    factory {
        get<Retrofit>().create(LoginApiService::class.java)
    }
}

val loginRepoModule = module {
    single {
        LoginRepository(get())
    }
}

val loginViewModelModule = module {
    viewModel {
        LoginViewModel(get())
    }
}