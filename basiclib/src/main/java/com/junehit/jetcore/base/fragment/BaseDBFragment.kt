package com.junehit.jetcore.base.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.utils.CommonUtil
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *Created by june
 *on 2020/9/8
 */
abstract class BaseDBFragment<VM : BaseViewModel, DB : ViewDataBinding>(layoutId: Int) : BaseFragment(layoutId) {

    protected lateinit var mViewModel: VM
    protected lateinit var mDataBinding: DB

    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?) {
        mDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        mDataBinding.lifecycleOwner = this
        mRootView = mDataBinding.root
    }

    override fun initViewModel() {
        mViewModel = if (shareViewModel()) {
            getSharedViewModel(clazz = CommonUtil.getClass<VM>(this).kotlin)
        } else {
            getViewModel(clazz = CommonUtil.getClass<VM>(this).kotlin)
        }

        registerUiEvent(mViewModel)
    }
}