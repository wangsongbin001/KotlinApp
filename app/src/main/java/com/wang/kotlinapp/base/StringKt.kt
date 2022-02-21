package com.wang.kotlinapp.base

class StringKt {
}

var aa: String? = null

fun main() {
    val text = """
        AAAAAAA
        bbbbbbb
        ccccccc
    """

    val text2 = """
        ?AAAAAAA
        ?bbbbbbb
        ?ccccccc
    """

    println(text)
    println(text.trimIndent())
    println(text2.trimMargin("?"))

    println(aa?.length ?: "")

    //Todo 比较
    var aa = "11"
    var bb = "11"
    var cc: String = String(charArrayOf('1', '1'))
    println(aa.equals(bb)) //true
    println(aa == bb) //true
    println(aa == cc) //true
    println(aa === cc) //false

    //todo 数组
    var a = arrayOf(1, 2, 3)
    for (num in a) {
        println(num)
    }
    var b = Array(20) { value: Int -> value + 3 }
    for (num in b) {
        println(num)
    }

}