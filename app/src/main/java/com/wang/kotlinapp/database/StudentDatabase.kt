package com.wang.kotlinapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * room数据库
 */
@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    companion object {

        private var INSTANCE: StudentDatabase? = null

        // Application
        fun getDatabase(context: Context): StudentDatabase? {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    StudentDatabase::class.java,
                    "student_database.db"
                )
                    .allowMainThreadQueries() // 允许在主线程运行
                    .build()
            }

            return INSTANCE

        }

        fun getDatabase(): StudentDatabase? = INSTANCE
    }
}