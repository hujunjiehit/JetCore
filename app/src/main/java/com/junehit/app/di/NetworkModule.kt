package com.junehit.app.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.Interceptor.Companion.invoke
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import javax.inject.Singleton


/**
 *Created by june
 *on 2020/9/9
 */

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor("httpLog"))
            .addInterceptor(headerIntereceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder().baseUrl("http://a.test.atomchain.vip")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build().also {
                Log.e("TestHilt", "=====>$it")
            }
    }
}

fun logInterceptor(tag : String = "httpLog") : Interceptor {
    return HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            try {
                val text: String = URLDecoder.decode(message, "utf-8")
                Log.d(tag, text)
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
                Log.e(tag, message)
            }
        }
    }).apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}

fun headerIntereceptor() : Interceptor {
    return invoke { chain ->
        val request = chain.request().newBuilder()
            .addHeader("site", "MAIN")
            .addHeader("lang","zh_CN")
            .build()
        chain.proceed(request)
    }
}