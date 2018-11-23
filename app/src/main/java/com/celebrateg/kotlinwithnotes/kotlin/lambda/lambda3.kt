package com.example.issuser.myapplication.kotlin.lambda

/**
 * @Author CelebrateG
 * @Description 带有 接收者 的函数字面值
 * 可以理解为 带有 接收者 的函数类型
 * @Date  2018/11/9
 */

/**
 * 使接收者对象成为隐式的 this
 * 可以访问接收者对象的成员 即 String 的成员 repeat
 * 类似于扩展函数，允许在函数体内部访问接收者对象的成员
 * this. 可以省略
 */
val repeatFun : String.(Int) -> String = {
    // times Int型参数
    times -> this.repeat(times)
}

/**
 * 带与不带 接收者 的函数类型可以互换
 */
val twoParamters:(String,Int) -> String = repeatFun
val result = twoParamters("twoParamters ",1)

fun thirdFun(f:(String,Int)->String):String{
    return f("hello ",2)
}
val result2 = thirdFun(repeatFun)


/**
 * 带接收者的匿名函数
 */
val pdd = fun Int.(other: Int): Int = this + other

fun main(args: Array<String>) {
    println(result)
    println(result2)
    println(pdd)
}