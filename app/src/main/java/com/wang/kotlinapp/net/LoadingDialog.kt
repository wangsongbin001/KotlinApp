package com.wang.kotlinapp.net

import android.app.Dialog
import android.content.Context
import com.wang.kotlinapp.R

object LoadingDialog {

    private var dialog: Dialog? = null

    fun showDialog(context: Context) {
        cancel()
        dialog = Dialog(context).apply {
            setContentView(R.layout.dialog_loading)
            setCancelable(true)
            setCanceledOnTouchOutside(true)
        }
        dialog?.show()
    }

    fun cancel() {
        dialog?.cancel()
        dialog = null
    }
}