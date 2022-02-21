package com.wang.kotlinapp.biz.account.register

import android.content.Context
import com.wang.kotlinapp.biz.account.login.inner.UserBean
import com.wang.kotlinapp.biz.account.register.inner.IRegisterPresenter
import com.wang.kotlinapp.biz.account.register.inner.IRegisterView
import com.wang.kotlinapp.biz.account.register.inner.RegisterRepository

class RegisterPresenterImp(var registerView: IRegisterView?) : IRegisterPresenter(),
    IRegisterPresenter.OnRegisterListener {

    private val registerRepository: RegisterRepository = RegisterRepository()

    override fun register(context: Context, username: String, password: String) {
        registerRepository.register(context, username, password, this)
    }

    override fun registerSuccess(userBean: UserBean) {
        registerView?.registerSuccess(userBean)
    }

    override fun registerFailure(errorCode: Int, errorMsg: String) {
        registerView?.registerFailure(errorCode, errorMsg)
    }

    override fun unAttachView() {
        registerView = null
    }
}