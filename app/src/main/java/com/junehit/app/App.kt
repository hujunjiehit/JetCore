package com.junehit.app

import android.app.Application
import com.junehit.jetcore.JetCore
import com.junehit.jetcore.kotlin.logd
import com.junehit.jetcore.loadsir.EmptyCallback
import com.junehit.jetcore.loadsir.ErrorCallback
import com.junehit.jetcore.loadsir.LoadingCallback
import com.kingja.loadsir.core.LoadSir
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager
import com.tencent.mmkv.MMKV
import dagger.hilt.android.HiltAndroidApp


/**
 *Created by june
 *on 2020/8/31
 */
@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        JetCore.initJetCore(this)
    }
}