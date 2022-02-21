package com.wang.common.utils

import android.content.Context
import android.widget.Toast

object CommonUtil {

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}