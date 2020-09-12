package com.junehit.jetcore.base.fragment

import androidx.lifecycle.ViewModelProvider
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.utils.CommonUtil

/**
 *Created by june
 *on 2020/9/8
 */
abstract class BaseVMFragment<VM : BaseViewModel<*>>(layoutId: Int) : BaseFragment(layoutId) {

    protected lateinit var mViewModel: VM

    override fun initViewModel() {
        mViewModel = if (shareViewModel()) {
            ViewModelProvider(requireActivity()).get(CommonUtil.getClass(this))
        } else {
            ViewModelProvider(this).get(CommonUtil.getClass(this))
        }
        registerUiEvent(mViewModel)
    }
}