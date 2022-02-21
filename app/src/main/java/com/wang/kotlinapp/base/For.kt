package com.wang.kotlinapp.base

class For {
}

// todo 标签和循环
fun main() {
    ttt@ for (i in 1..20) {
        for (j in 1..20) {
            print("i:$i j:$j ")
            if (i == 5)
                break@ttt
//                break
        }
        println()
    }
    val names = listOf<String>("张三", "里斯", "王武")
    names.forEach{
        println(it)
    }
    for (index in names.indices){
        println("index:$index name:${names[index]}")
    }
}