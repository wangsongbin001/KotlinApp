package com.wang.kotlinapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student() {
    //主key 自动增长
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    //可以加别名，优先级更好
    @ColumnInfo(name = "name")
    var name: String = ""

    var age: Int = 0

    constructor(name: String, age: Int) : this() {
        this.age = age
        this.name = name
    }
}