package com.junehit.jetcore.base.activity

import androidx.lifecycle.ViewModelProvider
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.utils.CommonUtil

/**
 *Created by june
 *on 2020/8/31
 */
abstract class BaseVMActivity<VM : BaseViewModel<*>>(layoutId: Int) : BaseActivity(layoutId) {

    protected lateinit var mViewModel: VM

    override fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(CommonUtil.getClass(this))
        registerUiEvent(mViewModel)
    }
}