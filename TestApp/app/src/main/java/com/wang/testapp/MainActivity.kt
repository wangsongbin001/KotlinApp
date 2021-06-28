package com.wang.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        main_test.setOnClickListener() {
//            ARouter.getInstance()
//                .build("/test/third")
//                .withParcelable(
//                    "user",
//                    UserBean<Book>("zhangsan", 18, MutableList<Book>(3) { Book("" + it) })
//                )
//                .navigation(this);
//        }
        main_test.setOnClickListener() {
            ARouter.getInstance()
                .build("/test/second")
                .withParcelable(
                    "user",
                    UserBean<Book>("zhangsan", 18, MutableList<Book>(3) { Book("" + it) })
                )
                .navigation(this);
        }
    }

}