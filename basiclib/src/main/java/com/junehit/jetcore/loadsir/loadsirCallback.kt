package com.junehit.jetcore.loadsir

import com.junehit.jetcore.R
import com.kingja.loadsir.callback.Callback

/**
 *Created by june
 *on 2020/9/10
 */
class LoadingCallback : Callback() {
    override fun onCreateView() = R.layout.layout_loading

    override fun getSuccessVisible() = true
}

class ErrorCallback : Callback() {
    override fun onCreateView()= R.layout.layout_error
}

class EmptyCallback : Callback() {
    override fun onCreateView()= R.layout.layout_empty
}