package com.wang.kotlinapp.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 1，单例
 * 2，okHttpclient
 * 3, retrofit
 */
class ApiClient {

    object Holder {
        val instance = ApiClient()
    }

    companion object {
        private const val BaseUrl = "https://www.wanandroid.com"
        private val retrofit: Retrofit = initRetrofit()

        fun instance() = Holder.instance

        fun <T> create(api: Class<T>): T {
            return retrofit.create(api)
        }

        fun initRetrofit(): Retrofit {
            val client = OkHttpClient().newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }


}