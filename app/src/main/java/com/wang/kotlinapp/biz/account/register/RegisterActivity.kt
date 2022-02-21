package com.wang.kotlinapp.biz.account.register

import android.os.Bundle
import android.os.Parcel
import android.util.Log
import android.view.View
import com.wang.common.BaseActivity
import com.wang.common.utils.CommonUtil
import com.wang.kotlinapp.R
import com.wang.kotlinapp.biz.account.login.inner.ILoginPresenter
import com.wang.kotlinapp.biz.account.login.inner.ILoginView
import com.wang.kotlinapp.biz.account.login.inner.UserBean
import com.wang.kotlinapp.biz.account.login.LoginPresenterImp
import com.wang.kotlinapp.biz.account.register.inner.IRegisterPresenter
import com.wang.kotlinapp.biz.account.register.inner.IRegisterView
import kotlinx.android.synthetic.main.activity_user_login.*
import kotlinx.android.synthetic.main.activity_user_register.*
import kotlinx.android.synthetic.main.activity_user_register.user_password_et
import kotlinx.android.synthetic.main.activity_user_register.user_phone_et

class RegisterActivity() : BaseActivity<IRegisterPresenter>(), IRegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)
        user_register_bt.setOnClickListener(onClickListener)
    }

    override fun createP(): IRegisterPresenter {
        return RegisterPresenterImp(this)
    }

    override fun recycle() {
        presenter.unAttachView()
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.user_register_bt -> {
                val username = user_phone_et.text.toString()
                val password = user_password_et.text.toString()
                Log.i("register", "username:$username password:$password")
                presenter.register(this, username, password)
            }
        }
    }

    override fun registerSuccess(userBean: UserBean) {
        CommonUtil.showToast(this, "注册成功！")
        Log.i("register", userBean.toString())

    }

    override fun registerFailure(errorCode: Int, errorMsg: String) {
        CommonUtil.showToast(this, "注册失败！")
        Log.i("register", errorMsg)
    }
}