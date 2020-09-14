package com.junehit.jetcore.base.activity

import androidx.lifecycle.ViewModelProvider
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.utils.CommonUtil
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *Created by june
 *on 2020/8/31
 */
abstract class BaseVMActivity<VM : BaseViewModel>(layoutId: Int) : BaseActivity(layoutId) {

    protected lateinit var mViewModel: VM

    override fun initViewModel() {
        mViewModel = getViewModel(clazz = CommonUtil.getClass<VM>(this).kotlin)

        registerUiEvent(mViewModel)
    }
}