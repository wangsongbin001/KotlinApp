package com.wang.kotlinapp

import android.app.Application
import com.wang.kotlinapp.database.StudentDatabase

class MApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        StudentDatabase.getDatabase(this)
    }
}