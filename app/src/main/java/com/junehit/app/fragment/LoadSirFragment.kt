package com.junehit.app.fragment

import com.junehit.app.R
import com.junehit.jetcore.base.fragment.BaseVMFragment
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_test.*

/**
 *Created by june
 *on 2020/9/11
 */
class LoadSirFragment :BaseVMFragment<TestViewModel>(R.layout.fragment_loadsir) {
    override fun initView() {

    }

    var count = 0

    override fun onFragmentShow() {
        super.onFragmentShow()

        when(count++ % 3) {
            0 -> mViewModel.showEmpty()
            1 -> mViewModel.showError()
            2 -> mViewModel.showSuccess()
        }

        Logger.e("TestFragment","${tvText.text} ====> onFragmentShow")
    }

    override fun shareViewModel(): Boolean {
        return false
    }
}