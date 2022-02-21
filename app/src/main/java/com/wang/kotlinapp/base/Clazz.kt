package com.wang.kotlinapp.base

//todo kt中的对象
open class Person(id: Int) {
    //主构造
    //次构造
    constructor(id: Int, name: String) : this(id) {
    }
}

// 父类加open才能被继承
class Student(id: Int) : Person(id) {

}

// 接口默认open
interface Callback {

}

// 数据类,
// 如果没有默认值，json解析是会为null crash
data class User(val id: Int)

//todo 单例
class NetManager{
    object Holder{
        val instance = NetManager()
    }

    companion object{
        fun getIntance():NetManager{
            return Holder.instance
        }
    }
}

fun main() {
    NetManager.getIntance();
}