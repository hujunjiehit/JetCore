package com.junehit.login

import com.junehit.jetcore.base.activity.BaseDBActivity
import com.junehit.login.databinding.ActivityLoginBinding

class LoginActivity : BaseDBActivity<LoginViewModel, ActivityLoginBinding>(R.layout.activity_login) {

    override fun initView() {

        setTitle("登录")

        mDataBinding.viewModel = mViewModel
    }
}