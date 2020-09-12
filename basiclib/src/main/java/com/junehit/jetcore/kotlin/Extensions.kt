package com.junehit.jetcore.kotlin

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.qmuiteam.qmui.widget.tab.QMUITabSegment2

/**
 *Created by june
 *on 2020/9/7
 */
inline fun <reified T> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    this.startActivity(intent)
}

inline fun <reified T> Context.startActivity(block: Intent.() -> Unit) {
    val intent = Intent(this, T::class.java)
    intent.block()
    this.startActivity(intent)
}



inline fun ViewPager2.initWithTabsegment(activity : FragmentActivity, list: List<String>,
                                         tabSegment: QMUITabSegment2, mode : Int = QMUITabSegment2.MODE_FIXED, crossinline getFragment : (Int) -> Fragment) {

    adapter = object :  FragmentStateAdapter(activity){
        override fun getItemCount(): Int {
            return list.size
        }

        override fun createFragment(position: Int): Fragment {
            return getFragment.invoke(position)
        }
    }
    offscreenPageLimit = list.size

    val tabBuilder = tabSegment.tabBuilder()
    list.forEach {
        tabSegment.addTab(tabBuilder.setText(it).build(activity))
    }
    tabSegment.notifyDataChanged()

    tabSegment.setupWithViewPager(this)
}
