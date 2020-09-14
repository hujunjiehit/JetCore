package com.junehit.jetcore.base.fragment

import androidx.lifecycle.ViewModelProvider
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.utils.CommonUtil
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.TypeQualifier
import kotlin.reflect.KClass

/**
 *Created by june
 *on 2020/9/8
 */
abstract class BaseVMFragment<VM : BaseViewModel>(layoutId: Int) : BaseFragment(layoutId) {

    protected lateinit var mViewModel: VM

    override fun initViewModel() {
        mViewModel = if (shareViewModel()) {
            getSharedViewModel(clazz = CommonUtil.getClass<VM>(this).kotlin)
        } else {
            getViewModel(clazz = CommonUtil.getClass<VM>(this).kotlin)
        }

        registerUiEvent(mViewModel)
    }
}