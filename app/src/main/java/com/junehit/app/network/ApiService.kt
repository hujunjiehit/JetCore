package com.junehit.app.network

import com.junehit.app.network.model.Banner
import com.junehit.jetcore.base.repository.BaseApiService
import com.junehit.jetcore.network.response.BaseRes
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Created by june
 *on 2020/9/9
 */
interface ApiService : BaseApiService {
    @GET("/content/getbanner")
    suspend fun getBanner(@Query("position") position : String) : BaseRes<List<Banner>>
}