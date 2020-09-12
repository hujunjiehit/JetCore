package com.junehit.jetcore.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.junehit.jetcore.R
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.loadsir.EmptyCallback
import com.junehit.jetcore.loadsir.ErrorCallback
import com.junehit.jetcore.loadsir.LoadingCallback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.orhanobut.logger.Logger
import com.qmuiteam.qmui.arch.QMUIActivity
import com.qmuiteam.qmui.widget.QMUITopBarLayout
import kotlinx.android.synthetic.main.base_activity_layout.*


/**
 *Created by june
 *on 2020/8/31
 */
abstract class BaseActivity(@LayoutRes var layoutId : Int) : QMUIActivity(){

    val loadService: LoadService<*> by lazy {
        LoadSir.getDefault().register(viewContainer) {
            reLoad()
        }
    }

    open fun reLoad() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()

        topBar.apply {
            addLeftImageButton(R.drawable.qmui_icon_topbar_back, R.id.iv_left_image).setOnClickListener{
                onBack()
            }
            visibility = if (hideTopBar()) View.GONE else View.VISIBLE
        }

        initViewModel()

        initView()

        setListener()

        initData()
    }

    open fun initLayout() {
        setContentView(R.layout.base_activity_layout)
        LayoutInflater.from(this).inflate(layoutId, viewContainer)
    }

    open fun initViewModel() {

    }

    fun setTitle (title : String) {
        topBar.apply {
            setTitle(title)
        }
    }

    fun getTopBar() : QMUITopBarLayout {
        return topBar
    }

    abstract fun initView()

    open fun setListener() {}

    open fun initData() {}

    /**
     * 点击标题栏返回
     */
    protected open fun onBack() {
        finish()
    }

    open fun hideTopBar(): Boolean = false

    fun registerUiEvent(viewModel : BaseViewModel<*>) {
        viewModel.uiEvent.showLoading.observe(this, Observer {
            showLoading()
        })

        viewModel.uiEvent.hideLoading.observe(this, Observer {
            hideLoading()
        })

        viewModel.uiEvent.showEmpty.observe(this, Observer {
            showEmpty()
        })

        viewModel.uiEvent.showError.observe(this, Observer {
            showError()
        })
    }

    open fun showLoading() {
        Logger.d("showLoading")
        loadService.showCallback(LoadingCallback::class.java)
    }

    open fun hideLoading() {
        Logger.d("hideLoading")
        loadService.showCallback(SuccessCallback::class.java)
    }

    open fun showEmpty() {
        Logger.d("showEmpty")
        loadService.showCallback(EmptyCallback::class.java)
    }

    open fun showError() {
        Logger.d("showError")
        loadService.showCallback(ErrorCallback::class.java)
    }
}