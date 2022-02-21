package com.wang.kotlinapp.biz.collect.inner

import com.wang.kotlinapp.database.Student

interface ICollectView {

    /**
     * 查询
     */
    fun showResultSuccess(students: List<Student>)

    /**
     * 增删改
     */
    fun showResult(action: Int, result: Boolean)
}