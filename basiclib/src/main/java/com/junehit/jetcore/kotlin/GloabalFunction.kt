package com.junehit.jetcore.kotlin

import com.orhanobut.logger.Logger

/**
 *Created by june
 *on 2020/9/8
 */

inline fun String.logd() {
    Logger.d(this)
}

inline fun String.loge() {
    Logger.e(this)
}

inline fun String.logi() {
    Logger.i(this)
}

inline fun String.logw() {
    Logger.w(this)
}

inline fun String.logjson() {
    Logger.json(this)
}