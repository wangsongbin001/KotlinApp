package com.wang.kotlinapp.biz.collect.inner

import com.wang.common.IBasePresenter
import com.wang.kotlinapp.database.Student

abstract class ICollectPresenter : IBasePresenter {

    abstract fun insertStudents(vararg students: Student)

    abstract fun queryStudents()

    abstract fun deleteAll()

    // → 回来处
    interface OnCollectResponseListener {
        fun showResultSuccess(result: List<Student> ?)
    }
    // → 回来处
    interface OnCollectListener {
        fun showIUD(iudResult: Boolean)
    }
}