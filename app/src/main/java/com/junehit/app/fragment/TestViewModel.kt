package com.junehit.app.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.junehit.app.network.model.Banner
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.sp.SpDeleagte

/**
 *Created by june
 *on 2020/9/8
 */
class TestViewModel : BaseViewModel<TestRespository>() {

    // 从Sp读取数据
    var cache by SpDeleagte("data", 1)

    var data = MutableLiveData<Int>(cache)

    fun increaseData() {
        data.value = data.value?.plus(1)

        //写入数据到SP
        cache = data.value ?: -1
    }


    fun getBanner() : LiveData<List<Banner>> = emit(true) {
        Log.e("getBanner","$this  === $mRepository")
        mRepository.getBanner()
    }

}