package com.wang.kotlinapp.biz.account.login.inner

import android.content.Context
import com.wang.common.IBasePresenter

abstract class ILoginPresenter : IBasePresenter {

    abstract fun login(context: Context, username: String, password: String)

    interface OnLoginListener {
        fun loginSuccess(loginBean: UserBean)

        fun loginFailure(errorCode: Int, errorMsg: String)
    }
}