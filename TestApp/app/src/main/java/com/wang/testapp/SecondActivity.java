package com.wang.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.security.keystore.UserNotAuthenticatedException;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/test/second")
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("second");
        setContentView(tv);

        UserBean user = getIntent().getParcelableExtra("user");
        Log.e("seond", user.toString());
    }
}
