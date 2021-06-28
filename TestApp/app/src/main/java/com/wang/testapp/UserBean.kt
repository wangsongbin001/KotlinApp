package com.wang.testapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserBean<T : Parcelable>(val name:String, val age:Int, val list: List<T>) : Parcelable