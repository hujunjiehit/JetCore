package com.junehit.jetcore.base.fragment

import android.os.Bundle
import android.util.Log
import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.junehit.jetcore.base.viewmodel.BaseViewModel
import com.junehit.jetcore.loadsir.EmptyCallback
import com.junehit.jetcore.loadsir.ErrorCallback
import com.junehit.jetcore.loadsir.LoadingCallback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.orhanobut.logger.Logger


/**
 *Created by june
 *on 2020/9/1
 */
abstract class BaseFragment(@LayoutRes var layoutId : Int) :  Fragment(){

    protected var mRootView: View? = null

    protected var isShowing = false
    protected var isFirstLoad = true

    val loadService: LoadService<*> by lazy {
        LoadSir.getDefault().register(mRootView){
            reLoad()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mRootView == null) {
            Log.e("TestFragment", "$this ===> initLayout")
            initLayout(inflater, container)
        }
        loadService.showSuccess()
        return loadService.loadLayout
    }

    open fun reLoad() {

    }

    open fun initLayout(inflater: LayoutInflater, container: ViewGroup?) {
        try {
            mRootView = inflater.inflate(layoutId, container, false)
        } catch (e: Exception) {
            if (e is InflateException) throw e
            e.printStackTrace()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
        setListener()
    }

    override fun onResume() {
        super.onResume()
        isShowing = true
        if (isFirstLoad) {
            initData()
            isFirstLoad = false
        }
        onFragmentShow()
    }

    override fun onPause() {
        super.onPause()
        isShowing = false
        onFragmentHide()
    }

    open fun initViewModel() {

    }

    /**
     *  viewmodel生命周期是否和activity一致，默认true
     */
    open fun shareViewModel() = true

    abstract fun initView()

    open fun setListener() {}

    open fun initData() {}

    open fun onFragmentShow() {}

    open fun onFragmentHide() {}


    fun registerUiEvent(viewModel : BaseViewModel) {
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
        Logger.d("showLoading $this")
        loadService.showCallback(LoadingCallback::class.java)
    }

    open fun hideLoading() {
        Logger.d("hideLoading $this")
        loadService.showCallback(SuccessCallback::class.java)
    }

    open fun showEmpty() {
        Logger.d("showEmpty $this")
        loadService.showCallback(EmptyCallback::class.java)
    }

    open fun showError() {
        Logger.d("showError $this")
        loadService.showCallback(ErrorCallback::class.java)
    }
}