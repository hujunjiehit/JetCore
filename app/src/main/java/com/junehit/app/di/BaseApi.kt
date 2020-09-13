package com.junehit.app.di

import com.junehit.jetcore.network.response.BaseRes

/**
 *Created by june
 *on 2020/9/13
 */
class BaseApi<T>(val errorCode : Int, val errorMsg : String,  override val  data: T) : BaseRes<T>(errorCode, errorMsg, data) {
    override fun isSuccess() = errorCode == 200


    override val code: Int get() = errorCode

    override val message: String get() = errorMsg
}