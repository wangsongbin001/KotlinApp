package com.wang.kotlinapp.biz.account.login.inner

import android.content.Context
import com.wang.kotlinapp.api.WanAndroidApi
import com.wang.kotlinapp.bean.ResultBean
import com.wang.kotlinapp.net.ApiClient
import com.wang.kotlinapp.net.ApiResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginRepository {
    private var observable: Observable<ResultBean<UserBean>>? = null

    fun login(
        context: Context,
        username: String,
        password: String,
        listener: ILoginPresenter.OnLoginListener
    ) {
        observable = ApiClient.create(WanAndroidApi::class.java)
            .login(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        observable?.subscribe(object : ApiResponse<UserBean>(context) {

            override fun success(dataBean: UserBean) {
                listener.loginSuccess(dataBean)
            }

            override fun failure(errorCode: Int, errorMsg: String) {
                listener.loginFailure(errorCode, errorMsg)
            }
        })
    }

    fun cancelRequest() {

    }
}