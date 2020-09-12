package com.junehit.jetcore.network

import com.junehit.jetcore.network.response.BaseRes
import java.lang.Exception

/**
 *Created by june
 *on 2020/9/10
 */
class ResponseThrowable : Exception {
    var code: Int
    var errMsg: String

    constructor(error: ERROR, e: Throwable? = null) : super(e) {
        code = error.getKey()
        errMsg = error.getValue()
    }

    constructor(code: Int, msg: String, e: Throwable? = null) : super(e) {
        this.code = code
        this.errMsg = msg
    }

    constructor(base: BaseRes<*>, e: Throwable? = null) : super(e) {
        this.code = base.code
        this.errMsg = base.message
    }
}