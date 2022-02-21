package com.wang.kotlinapp.biz.account.login

import android.os.Bundle
import android.util.Log
import android.view.View
import com.wang.common.BaseActivity
import com.wang.common.utils.CommonUtil
import com.wang.kotlinapp.R
import com.wang.kotlinapp.biz.account.login.inner.UserBean
import com.wang.kotlinapp.biz.account.login.inner.ILoginPresenter
import com.wang.kotlinapp.biz.account.login.inner.ILoginView
import kotlinx.android.synthetic.main.activity_user_login.*

class LoginActivity : BaseActivity<ILoginPresenter>(), ILoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        user_login_bt.setOnClickListener(onClickListener)
    }

    override fun createP(): ILoginPresenter = LoginPresenterImp(this)

    override fun recycle() {
        presenter.unAttachView()
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.user_login_bt -> {
                val username = user_phone_et.text.toString()
                val password = user_password_et.text.toString()
                Log.i("login", "username:$username password:$password")
                presenter.login(this, username, password)
            }
        }
    }

    override fun loginSuccess(data: UserBean) {
        CommonUtil.showToast(this, "登录成功！")
        Log.i("login", data.toString())
    }

    override fun loginFailure(errorCode: Int, errorMsg: String) {
        CommonUtil.showToast(this, "errorCode:$errorCode errorMsg:$errorMsg")
    }

}

