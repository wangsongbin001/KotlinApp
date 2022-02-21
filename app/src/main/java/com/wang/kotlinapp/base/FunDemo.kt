package com.wang.kotlinapp.base

class FunDemo {
}

fun main() {
    println("${add(1, 1)}")
    println("${add2(1, 2)}")
    println("${add3(1, 2, 3, 4, 5, 6)}")
    //lambda 函数
    val addMethod: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }
    println("${addMethod(8, 9)}")
}

fun add(number: Int, number2: Int): Int {
    return number + number2
}

//类型推到
fun add2(number: Int, number2: Int) = number + number2
//fun add2(number: Int, number2: Int) = "AAA"

//可变参数
fun add3(vararg num: Int): Int {
    var result: Int = 0;
    for (i in num) {
        result += i;
    }
    return result;
}