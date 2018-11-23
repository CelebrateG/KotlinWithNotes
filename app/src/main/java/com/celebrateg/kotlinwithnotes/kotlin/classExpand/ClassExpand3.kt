package com.example.issuser.myapplication.kotlin.classExpand

/**
 * @Author CelebrateG
 * @Description 成员函数与扩展函数相同
 * 使用该函数时，会优先使用成员函数
 * @Date  2018/10/23
 */

class E {
    //成员函数
    fun foo() {
        println("member")
    }
}
/**
 * 扩展函数
 */
fun E.foo() {
    println("extension")
}

/**
 * 扩展函数重载
 */
fun E.foo(i: Int) {
    println("extension:$i")
}