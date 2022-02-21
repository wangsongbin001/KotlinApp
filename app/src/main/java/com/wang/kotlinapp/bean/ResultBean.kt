package com.wang.kotlinapp.bean


data class ResultBean<T>(val data: T, val errorCode: Int, val errorMsg: String)