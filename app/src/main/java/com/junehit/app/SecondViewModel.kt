package com.junehit.app

import androidx.lifecycle.MutableLiveData
import com.junehit.app.fragment.TestRespository
import com.junehit.jetcore.base.viewmodel.BaseViewModel

/**
 *Created by june
 *on 2020/9/1
 */
class SecondViewModel : BaseViewModel<TestRespository>() {

    var count : MutableLiveData<Int> = MutableLiveData(0)


}