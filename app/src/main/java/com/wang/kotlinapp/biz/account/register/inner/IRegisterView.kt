package com.wang.kotlinapp.biz.account.register.inner

import com.wang.kotlinapp.biz.account.login.inner.UserBean

interface IRegisterView {

    fun registerSuccess(userBean: UserBean)

    fun registerFailure(errorCode: Int, errorMsg: String)
}