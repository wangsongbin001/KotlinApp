package com.wang.kotlinapp.biz.account.register.inner

import android.content.Context
import com.wang.kotlinapp.api.WanAndroidApi
import com.wang.kotlinapp.biz.account.login.inner.UserBean
import com.wang.kotlinapp.net.ApiClient
import com.wang.kotlinapp.net.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterRepository {

    fun register(
        context: Context,
        username: String,
        password: String,
        onRegisterListener: IRegisterPresenter.OnRegisterListener
    ) {
        ApiClient.create(WanAndroidApi::class.java)
            .register(username, password, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiResponse<UserBean>(context) {

                override fun success(dataBean: UserBean) {
                    onRegisterListener.registerSuccess(dataBean)
                }

                override fun failure(errorCode: Int, errorMsg: String) {
                    onRegisterListener.registerFailure(errorCode, "请检测异常：$errorMsg")
                }
            })

    }

    fun cancelRequest(){

    }
}