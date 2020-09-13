package com.junehit.jetcore.base.repository

import com.junehit.jetcore.context.ContextRepo
import com.junehit.jetcore.utils.CommonUtil
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

/**
 *Created by june
 *on 2020/9/8
 */
open class BaseRepository<T :  BaseApiService>() {

    val mApiService by lazy {
        EntryPointAccessors.fromApplication(ContextRepo.mContext, RetrofitEntryPoint::class.java)
            .retrofit().create(CommonUtil.getClass<T>(this))
    }

    @EntryPoint
    @InstallIn(ApplicationComponent::class)
    interface RetrofitEntryPoint {
        fun retrofit() : Retrofit
    }

}