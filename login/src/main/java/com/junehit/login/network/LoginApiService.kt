package com.junehit.login.network

import com.junehit.jetcore.base.repository.BaseApiService
import com.junehit.jetcore.network.response.BaseRes
import com.junehit.login.network.model.UserInfo
import retrofit2.http.POST
import retrofit2.http.Query

/**
 *Created by june
 *on 2020/9/10
 */
interface LoginApiService : BaseApiService {

//    @GET("/content/getbanner")
//    suspend fun getBanner(@Query("position") position : String) : BaseRes<List<Banner>>

    @POST("/user/public/auth/loginV3")
    suspend fun login(@Query("loginId") userName : String, @Query("passwd") password : String) : BaseRes<UserInfo>



}