package com.junehit.app.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.junehit.app.R
import com.junehit.jetcore.base.fragment.BaseVMFragment
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_test.*

/**
 *Created by june
 *on 2020/9/7
 */
class TestFragment : BaseVMFragment<TestViewModel>(R.layout.fragment_test) {
    companion object {
        fun newInstance(params : String): TestFragment{
            val args = Bundle()
            args.putString("params", params)
            val fragment = TestFragment()
            fragment.arguments = args
            return fragment
        }

        const val showLog = true
    }

    override fun initView() {
       tvText.text = arguments?.getString("params")
    }

    override fun onAttach(context: Context) {
        if (showLog) {
            Log.e("TestFragment","$this ====> onAttach")
        }
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (showLog) {
            Log.e("TestFragment","$this ====> onCreate")
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (showLog) {
            Log.e("TestFragment","$this ====> onCreateView")
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (showLog) {
            Log.e("TestFragment","$this ====> onViewCreated")
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        if (showLog) {
            Log.e("TestFragment","$this ====> onStart")
        }
        super.onStart()
    }

    override fun onResume() {
        if (showLog) {
            Log.e("TestFragment","$this ====> onResume")
        }
        super.onResume()
    }

    override fun onStop() {
        if (showLog) {
            Log.e("TestFragment","$this ====> onStop")
        }

        super.onStop()
    }

    override fun onDestroyView() {
        if (showLog) {
            Log.e("TestFragment","$this ====> onDestroyView")
        }

        super.onDestroyView()
    }

    override fun onDestroy() {
        if (showLog) {
            Log.e("TestFragment","$this ====> onDestroy")
        }

        super.onDestroy()
    }

    override fun onDetach() {
        if (showLog) {
            Log.e("TestFragment","$this ====> onDetach")
        }

        super.onDetach()
    }


    override fun onFragmentShow() {
        super.onFragmentShow()
        Logger.e("TestFragment","${tvText.text} ====> onFragmentShow")
    }

    override fun onFragmentHide() {
        super.onFragmentHide()
        Log.e("TestFragment","${tvText.text} ====> onFragmentHide")
    }
}