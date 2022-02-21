package com.wang.kotlinapp.dataloacl

import com.wang.kotlinapp.database.Student
import com.wang.kotlinapp.database.StudentDao
import com.wang.kotlinapp.database.StudentDatabase

/**
 * 1,单例
 * 2,StudentDao
 */
class LocalRoomRequestManager : ILocalRequest, IDataRequest {

    private var studentDao: StudentDao? = null

    init {
        studentDao = StudentDatabase.getDatabase()?.getStudentDao()
    }

    object Holder {
        val Instance = LocalRoomRequestManager()
    }

    companion object {
        fun getInstance() = Holder.Instance
    }

    override fun insertStudents(vararg students: Student) {
        studentDao?.insertStudents(*students)
    }

    override fun queryStudents(): List<Student> {
        return studentDao?.queryStudents() ?: arrayListOf<Student>()
    }

    override fun deleteAll() {
        studentDao?.deleteAll()
    }
}