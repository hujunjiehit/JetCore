package com.junehit.app.fragment

import com.junehit.app.R
import com.junehit.app.SecondActivity
import com.junehit.jetcore.base.fragment.BaseVMFragment
import com.junehit.jetcore.kotlin.logd
import com.junehit.jetcore.kotlin.loge
import com.junehit.jetcore.kotlin.startActivity
import com.junehit.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_test.*

/**
 *Created by june
 *on 2020/9/8
 */
class TestVmFragment : BaseVMFragment<TestViewModel>(R.layout.fragment_test) {

    override fun initView() {

    }

    override fun onFragmentShow() {
        "error".loge()

        "debug".logd()

        tvText.text = "$this"

        tvText.setOnClickListener {
            context?.startActivity<SecondActivity>()
        }

//        mViewModel.getBanner().observe(this, Observer {
//            Logger.d("${Thread.currentThread().name} ==> $it")
//        })

        btnLogin.setOnClickListener {
            context?.startActivity<LoginActivity>()
        }

        btnList.setOnClickListener {
            context?.startActivity<SecondActivity>()
        }
    }

    override fun shareViewModel() = false
}