package com.wang.testapp

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/test/third")
public class ThirdActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this)
        tv.setText("third")
        setContentView(tv)
    }

}