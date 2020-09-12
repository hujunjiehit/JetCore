package com.junehit.app.fragment

import com.junehit.app.network.ApiService
import com.junehit.app.network.model.Banner
import com.junehit.jetcore.base.repository.BaseRepository
import com.junehit.jetcore.network.response.convertData
import kotlinx.coroutines.delay


/**
 *Created by june
 *on 2020/9/10
 */
class TestRespository : BaseRepository<ApiService>() {

    suspend fun getBanner() : List<Banner> {
        val banner = mApiService.getBanner("APP").convertData()
        delay(2000)
        return banner
    }
}