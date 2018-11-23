package com.example.issuser.myapplication.kotlin.annotation

/**
 * @Author CelebrateG
 * @Description 应用注解
 * @Date  2018/11/16
 */

/**
 * 标记被弃用的方法，并提示替代方法
 */
@Deprecated("Use remove(index) instead.", ReplaceWith("removeAt(index)"))
fun remove(index : Int){
    println("remove(2)")
}

fun removeAt(index : Int){
    println("removeAt(2)")
}

const val TEST_TIMEOUT = 1000L

