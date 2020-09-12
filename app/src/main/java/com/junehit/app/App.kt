package com.junehit.app

import android.app.Application
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

        initLogger()

        val rootDir = MMKV.initialize(this)
        rootDir.logd()

        QMUISwipeBackActivityManager.init(this)

        LoadSir.beginBuilder()
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .addCallback(ErrorCallback())
            .commit()
    }

    private fun initLogger() {
        //        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
//            .showThreadInfo(false) // (Optional) Whether to show thread info or not. Default true
//            .methodCount(0) // (Optional) How many method line to show. Default 2
//            .methodOffset(7) // (Optional) Hides internal method calls up to offset. Default 5
//            .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
//            .tag("My custom tag") // (Optional) Global tag for every log. Default PRETTY_LOGGER
//            .build()
        Logger.addLogAdapter(AndroidLogAdapter(
            PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .build()
        ))
    }
}