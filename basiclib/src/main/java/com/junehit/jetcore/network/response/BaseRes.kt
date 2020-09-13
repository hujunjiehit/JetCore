package com.junehit.jetcore.network.response

import com.junehit.jetcore.network.ResponseThrowable

/**
 *Created by june
 *on 2020/9/9
 */
open class BaseRes<T>(val code: Int, val message: String, open val data: T) {

    open fun isSuccess() = code == 200

    open fun isExpired() = code == 401
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
