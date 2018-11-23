package com.example.issuser.myapplication.kotlin.grammer

/**
 * @Author CelebrateG
 * @Description 类型自动转化
 * @Date  2018/11/7
 */

fun typeExchange() {
    var l = 1L + 3 // Long + Int => Long
    var i = 0b00000010 + 2 // byte + Int
    var d = 10.3 + 2.5f // double + float
    var f = 3 + 3.3f // int + float
    var b = 0b00000010_00000001_00000011_00000100
    println("Long + Int is Long ? ${l is Long}")
    println("Byte + Int is Int ? ${i is Int}")
    println("Double + Float is Double ? ${d is Double}")
    println("Int + Float is Float ? ${f is Float}")
    println(b)
}