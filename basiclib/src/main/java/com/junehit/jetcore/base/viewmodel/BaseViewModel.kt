package com.junehit.jetcore.base.viewmodel

import androidx.lifecycle.*
import com.junehit.jetcore.base.repository.BaseRepository
import com.junehit.jetcore.event.SingleLiveEvent
import com.junehit.jetcore.network.ExceptionHandler
import com.junehit.jetcore.utils.CommonUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *Created by june
 *on 2020/8/31
 */
open class BaseViewModel : ViewModel() {

//    val mRepository : R by lazy {
//        // 获取对应Repository 实例 (有参构造函数)
//        (CommonUtil.getClass<R>(this))
//            // 获取构造函数的构造器，传入参数class
//            //.getDeclaredConstructor(BaseApiService::class.java)
//            // 传入加载状态
//            .newInstance()
//    }

    val uiEvent by lazy { UIEvent() }

    fun launch(showLoading : Boolean = false, error : ((e : Throwable) -> Unit) ? = null, block : suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            if (showLoading) showLoading()

            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    block()
                }
            }.onSuccess {
                if (showLoading) hideLoading()
            }.onFailure {
                if (showLoading) hideLoading()
                val handleException = ExceptionHandler.handleException(it)
                error?.invoke(handleException)
            }
        }
    }

    fun <T> emit(showLoading : Boolean = false, error : ((e : Throwable) -> Unit) ? = null,  block : suspend LiveDataScope<T>.() -> T) = liveData<T> {
        kotlin.runCatching {
            if (showLoading) uiEvent.showLoading.call()
            withContext(Dispatchers.IO) {
                emit(block())
            }
        }.onSuccess {

            if (showLoading) uiEvent.hideLoading.call()
        }.onFailure {
            if (showLoading) uiEvent.hideLoading.call()

            val handleException = ExceptionHandler.handleException(it)
            error?.invoke(handleException)
        }
    }


    fun showEmpty() {
        uiEvent.showEmpty.call()
    }

    fun showError() {
        uiEvent.showError.call()
    }

    fun showLoading() {
        uiEvent.showLoading.call()
    }

    fun hideLoading() {
        uiEvent.hideLoading.call()
    }

    fun showSuccess() {
        uiEvent.hideLoading.call()
    }

    inner class UIEvent {
        val showLoading by lazy { SingleLiveEvent<String>() }
        val hideLoading by lazy { SingleLiveEvent<Void>() }
        val showEmpty by lazy { SingleLiveEvent<Void>()  }
        val showError by lazy { SingleLiveEvent<Void>()  }
    }
}