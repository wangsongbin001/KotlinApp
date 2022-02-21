package com.wang.kotlinapp.dataloacl

import com.wang.kotlinapp.database.Student

interface IDataRequest {

    fun insertStudents(vararg students: Student)

    fun queryStudents(): List<Student>

    fun deleteAll()
}