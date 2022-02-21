package com.wang.kotlinapp.net

import android.content.Context
import com.wang.kotlinapp.bean.ResultBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class ApiResponse<T>(val context: Context) : Observer<ResultBean<T>> {

    private var isShow: Boolean = true

    constructor(context: Context, isShow: Boolean) : this(context) {
        this.isShow = isShow
    }

    override fun onSubscribe(d: Disposable) {
        if (isShow) {
            LoadingDialog.showDialog(context)
        }
    }

    override fun onNext(t: ResultBean<T>) {
        if (t.data != null) {
            success(t.data)
        } else {
            failure(t.errorCode, "请检查错误：${t.errorMsg}")
        }
    }

    override fun onError(e: Throwable) {
        LoadingDialog.cancel()
        failure(-1, "请检查错误：${e?.message}")
    }

    override fun onComplete() {
        LoadingDialog.cancel()
    }

    abstract fun success(dataBean: T)

    abstract fun failure(errorCode: Int, errorMsg: String)

}