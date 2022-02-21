package com.wang.kotlinapp.database

import androidx.room.*

/**
 * 增删改查
 */
@Dao
interface StudentDao {

    @Insert
    fun insertStudents(vararg students: Student)

    @Delete
    fun deleteStudents(vararg students: Student)

    @Update
    fun updateStudents(vararg students: Student)

    @Query("SELECT * FROM student ORDER BY ID DESC")
    fun queryStudents(): List<Student>

    @Query("DELETE FROM student")
    fun deleteAll()
}