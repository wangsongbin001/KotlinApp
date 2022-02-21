package com.wang.kotlinapp.base
class ValVar {

    var name:String = "wsb"
    val name2  = ""
}

fun main() {
    var valVar: ValVar = ValVar();
    println("${valVar.name} ${valVar.name2}")
}
