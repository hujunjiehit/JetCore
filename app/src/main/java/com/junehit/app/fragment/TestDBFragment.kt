package com.junehit.app.fragment

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.junehit.app.R
import com.junehit.app.databinding.FragmentTestBinding
import com.junehit.jetcore.base.fragment.BaseDBFragment
import kotlinx.android.synthetic.main.fragment_test.*

/**
 *Created by june
 *on 2020/9/8
 */
class TestDBFragment : BaseDBFragment<TestViewModel, FragmentTestBinding>(R.layout.fragment_test) {

    override fun initView() {
        mDataBinding.viewModel = mViewModel


        mDataBinding.btnLogin.text = "获取banner显示loading"

        mDataBinding.btnLogin.setOnClickListener {
            Log.e("getBanner","$this  === $mViewModel")
            mViewModel.getBanner().observe(this, Observer {

            })
        }

        btnList.visibility = View.GONE
    }
}