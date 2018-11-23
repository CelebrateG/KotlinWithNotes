package com.example.issuser.myapplication.kotlin.other

/**
 * @Author CelebrateG
 * @Description 重载一元运算符
 * @Date  2018/11/12
 */
operator fun Point.unaryMinus() = Point(-x, -y)

fun unaryOperator(){
    var point = Point(10,10)
    println(-point)
}
