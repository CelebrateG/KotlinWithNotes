package com.example.issuser.myapplication.kotlin.grammer

/**
 * @Author CelebrateG
 * @Description 区间表达式
 * @Date  2018/11/7
 */
fun arange() {
    //输出1到4
    for (i in 1..4) print(i)
    println("------------")

    //什么都不输出
    for (i in 4..1) print(i)
    println("------------")

    // 使用 step 指定步长
    for (i in 1..4 step 2) print(i)
    println("------------")
    for (i in 4 downTo 1 step 2) print(i)
    println("------------")

    //输出1到4
    for (i in 1 until 5) print(i)
    println("------------")
}