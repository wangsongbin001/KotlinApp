package com.wang.kotlinapp.biz.account.login.inner

interface ILoginView{

    fun loginSuccess(result: UserBean)

    fun loginFailure(errorCode: Int, errorMsg: String)
}