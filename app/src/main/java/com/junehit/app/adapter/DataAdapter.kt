package com.junehit.app.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.junehit.app.R
import com.junehit.app.databinding.ItemDataBinding
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 *Created by june
 *on 2020/9/1
 */
//@Singleton  //全局单例
@ActivityScoped // activity 生命周期内单例
class DataAdapter @Inject constructor() : BaseQuickAdapter<Data, BaseDataBindingHolder<ItemDataBinding>> (R.layout.item_data) {
    override fun convert(holder: BaseDataBindingHolder<ItemDataBinding>, item: Data) {
        holder.dataBinding?.item = item
        holder.dataBinding?.executePendingBindings()
    }
}

data class Data(val name : String, val age : Int)