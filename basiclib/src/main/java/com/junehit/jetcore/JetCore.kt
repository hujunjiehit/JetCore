package com.junehit.jetcore

import android.app.Application
import com.junehit.jetcore.context.ContextRepo
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

/**
 *Created by june
 *on 2020/9/12
 */
object JetCore {

    fun initJetCore(application : Application) {

        ContextRepo.mContext = application

        initLogger()

        val rootDir = MMKV.initialize(application)
        rootDir.logd()

        QMUISwipeBackActivityManager.init(application)

        LoadSir.beginBuilder()
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .addCallback(ErrorCallback())
            .commit()
    }

    private fun initLogger() {
        Logger.addLogAdapter(
            AndroidLogAdapter(
            PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .build()
        ))
    }
}