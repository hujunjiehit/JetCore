package com.junehit.jetcore.network.response

import com.junehit.jetcore.network.ResponseThrowable

/**
 *Created by june
 *on 2020/9/9
 */
data class BaseRes<T>(val code: Int, val message: String, val data: T) {

    fun isSuccess() = code == 200

    fun isExpired() = code == 401
}


/**
 * 数据解析扩展函数
 */
fun <T> BaseRes<T>.convertData() : T {
    if (isSuccess()) {
        return data
    }
    throw ResponseThrowable(code, message)
}
