package com.wang.kotlinapp.biz.account.login

import android.content.Context
import com.wang.kotlinapp.biz.account.login.inner.ILoginPresenter
import com.wang.kotlinapp.biz.account.login.inner.ILoginView
import com.wang.kotlinapp.biz.account.login.inner.LoginRepository
import com.wang.kotlinapp.biz.account.login.inner.UserBean

class LoginPresenterImp(private var loginView: ILoginView?) : ILoginPresenter(),
    ILoginPresenter.OnLoginListener {

    var loginRepository: LoginRepository = LoginRepository()

    override fun login(context: Context, username: String, password: String) {
        //控制层，前面可添加一些校验工作
        loginRepository.login(context, username, password, this)
    }

    override fun unAttachView() {
        loginView = null
        loginRepository.cancelRequest();
    }

    override fun loginSuccess(loginBean: UserBean) {
        loginView?.loginSuccess(loginBean)
    }

    override fun loginFailure(errorCode: Int, errorMsg: String) {
        loginView?.loginFailure(errorCode, errorMsg)
    }


}