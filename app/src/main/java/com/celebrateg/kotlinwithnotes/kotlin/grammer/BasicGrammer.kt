package com.example.issuser.myapplication.kotlin.grammer

/**
 * @Author CelebrateG
 * @Description 函数
 * @Date  2018/10/17
 */

fun sum(a: Int, b: Int): Int {
    return a + b
}
/**
 * 当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
 * 表达式作为函数体，返回类型自动推断
 */
fun sum1(a: Int, b: Int) = a + b
fun sum2(a: Int, b: Int): Int = a + b

//无返回值
fun printSum(a: Int, b: Int) {
    println(a + b)
}

//可变长参数
fun vars(vararg a: Int) {
    for (b in a) {
        print(b)
    }
}

