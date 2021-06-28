package com.wang.testapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(val name:String):Parcelable