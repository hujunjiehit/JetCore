package com.junehit.app

import androidx.lifecycle.lifecycleScope
import com.junehit.app.adapter.Data
import com.junehit.app.adapter.DataAdapter
import com.junehit.app.databinding.ActivitySecondBinding
import com.junehit.jetcore.base.activity.BaseDBActivity
import com.junehit.jetcore.kotlin.logd
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import kotlin.random.Random

/**
 *Created by june
 *on 2020/8/31
 */
class SecondActivity : BaseDBActivity<SecondViewModel, ActivitySecondBinding>(R.layout.activity_second){

    val mAdapter : DataAdapter by inject()

    override fun initView() {
        setTitle("second")

        mDataBinding.viewModel = mViewModel

        recyclerView.adapter = mAdapter

        mAdapter.toString().logd()

        showError()
    }

    override fun reLoad() {
        loadData()
    }

    private fun loadData() {
        val list = mutableListOf<Data>()
        var i = 0

        lifecycleScope.launch {
            showLoading()

            delay(2000)

            repeat(20){
                list.add(Data("name:${i++}", Random.nextInt(1, 100)))
            }
            mAdapter.addData(list)

            hideLoading()
        }
    }
}