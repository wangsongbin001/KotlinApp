package com.wang.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment<P> : Fragment() where P : IBasePresenter {

    lateinit var presenter: P
    private lateinit var mActivity: AppCompatActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createP()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createOK()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun createP(): P

    abstract fun recycle()

    abstract fun createOK()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    /**
     * 暴露给自己的孩子 隐藏ActionBar
     */
    fun hideActionBar() : Unit {
        val actionBar: ActionBar? = mActivity?.supportActionBar
        actionBar?.hide();
    }

    /**
     * 暴露给自己的孩子 显示ActionBar
     */
    fun showActionBar() : Unit {
        mActivity?.supportActionBar?.show()
    }
}