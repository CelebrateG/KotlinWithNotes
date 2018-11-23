package com.example.issuser.myapplication.kotlin.lambda

/**
 * @Author CelebrateG
 * @Description 高阶函数：
 * 将函数用作参数或返回值的函数
 * @Date  2018/10/30
 */

/**
 * 声明了一个扩展函数
 * 它接受一个初始累积值与一个 接合函数（函数类型的实例），
 * 并通过将当前累积值与每个集合元素连续接合起来
 * 代入累积值来构建返回值
 */
fun <T,R> Collection<T>.fold(
        initial:R,
        combine:(acc:R,nextElement:T)->R
):R{
    var accumulator :R = initial
    for (element:T in this){
        accumulator = combine(accumulator,element)
    }
    return accumulator
}

fun main(args: Array<String>) {
    val items = listOf(1, 2, 3, 4, 5)
    //使用 lambda 表达式
    items.fold(0) { acc:Int, nextElement:Int ->
        var result = acc + nextElement
        //lambda 表达式中最后一个表达式是返回值
        println("result=$result")
        result
    }

    /**
     * 如果函数的最后一个参数接受函数，
     * 那么该参数的 lambda 表达式可以放在圆括号之外
     */
    val joinedToString = items.fold("Elements:") {
        acc, nextElement ->  "$acc $nextElement"
    }
    println(joinedToString)

    /**
     * 函数引用也可以用于高阶函数调用
     * 此处调用了 Int.times 作为函数类型参数
     * 该函数只要满足 fold 函数的第二个参数类型即可
     * 可以看出 fold 第一个参数类型应与第二个参数类型相同
     * 否则会编译错误
     */
    val product = items.fold(1,Int::times)
    println(product)

}

