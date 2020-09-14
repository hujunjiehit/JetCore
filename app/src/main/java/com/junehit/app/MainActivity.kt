package com.junehit.app

import com.junehit.app.fragment.LoadSirFragment
import com.junehit.app.fragment.TestDBFragment
import com.junehit.app.fragment.TestFragment
import com.junehit.app.fragment.TestVmFragment
import com.junehit.jetcore.base.activity.BaseVMActivity
import com.junehit.jetcore.kotlin.initWithTabsegment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVMActivity<MainViewModel>(R.layout.activity_main) {

    override fun initView() {
        getTopBar().apply {
            setTitle("Main")
        }

        viewPager.initWithTabsegment(this, listOf("Tab0","Tab1","Tab2","Tab3","Tab4","Tab5","Tab6"), tabSegment) {
            when(it) {
                0 -> TestVmFragment()
                1 -> TestDBFragment()
                2 -> LoadSirFragment()
                else ->{
                    TestFragment.newInstance("我是Fragment $it")
                }
            }
        }
    }

    override fun hideTopBar(): Boolean {
        return false
    }
}