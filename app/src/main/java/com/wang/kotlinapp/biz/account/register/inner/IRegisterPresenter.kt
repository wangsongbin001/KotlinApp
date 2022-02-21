package com.wang.kotlinapp.biz.account.register.inner

import android.content.Context
import com.wang.common.IBasePresenter
import com.wang.kotlinapp.biz.account.login.inner.UserBean

abstract class IRegisterPresenter : IBasePresenter {

    abstract fun register(context: Context, username: String, password: String)

    interface OnRegisterListener {
        fun registerSuccess(userBean: UserBean)

        fun registerFailure(errorCode: Int, errorMsg: String)
    }
}