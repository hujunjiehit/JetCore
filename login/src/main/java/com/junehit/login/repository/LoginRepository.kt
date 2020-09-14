package com.junehit.login.repository

import com.junehit.jetcore.base.repository.BaseRepository
import com.junehit.jetcore.kotlin.loge
import com.junehit.jetcore.network.response.convertData
import com.junehit.login.network.LoginApiService
import com.junehit.login.network.model.UserInfo
import kotlinx.coroutines.delay

/**
 *Created by june
 *on 2020/9/10
 */
class LoginRepository(val apiService: LoginApiService) : BaseRepository() {

    suspend fun doLogin(username: String, password : String) : UserInfo {
        delay(2000)

        val login = apiService.login(username, password).convertData()

        login.toString().loge()
        return login
    }


}