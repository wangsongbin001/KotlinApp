package com.wang.kotlinapp.base

class If {
}

fun main() {
    val a = 101
    val b = if (a >= 60) "及格" else "不及格"
    println(b)
    val c = when (a) {
        in 80..100 -> "A"
        in 70..79 -> "B"
        in 60..69 -> "C"
        else -> "D"
    }
    println(c)
}