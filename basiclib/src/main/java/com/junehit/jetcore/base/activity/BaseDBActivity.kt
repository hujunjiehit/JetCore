package com.junehit.jetcore.base.activity

import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.junehit.jetcore.R
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.utils.CommonUtil
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *Created by june
 *on 2020/8/31
 */
abstract class BaseDBActivity<VM : BaseViewModel, DB : ViewDataBinding>(layoutId : Int) : BaseActivity(layoutId) {

    protected lateinit var mViewModel: VM
    protected lateinit var mDataBinding: DB

    override fun initLayout() {
        val rootView = LayoutInflater.from(this).inflate(R.layout.base_activity_layout, null)

        mDataBinding = DataBindingUtil.inflate(layoutInflater, layoutId, null, false)
        mDataBinding.lifecycleOwner = this

        rootView.findViewById<FrameLayout>(R.id.viewContainer).addView(mDataBinding.root)

        setContentView(rootView)
    }

    override fun initViewModel() {
        mViewModel = getViewModel(clazz = CommonUtil.getClass<VM>(this).kotlin)

        registerUiEvent(mViewModel)
    }
}