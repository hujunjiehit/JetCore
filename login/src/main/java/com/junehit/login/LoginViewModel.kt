package com.junehit.login

import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.ToastUtils
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.kotlin.loge
import com.junehit.login.repository.LoginRepository

/**
 *Created by june
 *on 2020/9/10
 */
class LoginViewModel(private val loginRepository: LoginRepository) : BaseViewModel() {

    var userName = MutableLiveData<String>()
    var passWord = MutableLiveData<String>()

    fun doLogin() {
        ToastUtils.showLong("${userName.value} <===> ${passWord.value}")

        launch(true) {
            Thread.currentThread().name.loge()
            loginRepository.doLogin(userName.value ?: "", passWord.value ?:"")
        }
    }
}