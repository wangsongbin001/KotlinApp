package com.wang.kotlinapp.api

import com.wang.kotlinapp.biz.account.login.inner.UserBean
import com.wang.kotlinapp.bean.ResultBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * baseUrl : https://www.wanandroid.com
 */
interface WanAndroidApi {

    @POST("/user/login")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<ResultBean<UserBean>>

    @POST("/user/register")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<ResultBean<UserBean>>

    @GET("/user/logout/json")
    fun loginOut()
}