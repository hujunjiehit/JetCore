package com.junehit.app

import android.os.Bundle
import com.qmuiteam.qmui.arch.QMUIActivity

/**
 *Created by june
 *on 2020/8/31
 */
class ThirdActivity : QMUIActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

    }
}