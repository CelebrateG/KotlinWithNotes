package com.example.issuser.myapplication.kotlin.classGenericity

/**
 * @Author CelebrateG
 * @Description kotlin 泛型类及泛型函数
 * @Date  2018/10/24
 */

class Box<T>(t : T){
    val value : T = t
}

/**
 * 类型参数要放在函数名称之前
 */
fun <T> boxIn(value : T) = Box(value)

fun <T> doPrintln(content : T){
    when(content){
        is Int -> println("整型类型")
        is String -> println("字符串类型")
        else -> println("非整型和非字符串类型")
    }
}