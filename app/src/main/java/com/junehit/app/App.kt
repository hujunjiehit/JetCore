package com.junehit.app

import android.app.Application
import com.junehit.app.di.appApiServiceModule
import com.junehit.app.di.appRepoModule
import com.junehit.app.di.appViewModelModule
import com.junehit.app.di.networkModule
import com.junehit.jetcore.JetCore
import com.junehit.login.di.loginApiServiceModule
import com.junehit.login.di.loginRepoModule
import com.junehit.login.di.loginViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 *Created by june
 *on 2020/8/31
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        JetCore.initJetCore(this)

        startKoin {
            androidLogger()
            androidContext(this@App)

            modules(
                networkModule,
                appViewModelModule, appRepoModule, appApiServiceModule,
                loginViewModelModule, loginRepoModule, loginApiServiceModule
            )
        }
    }
}