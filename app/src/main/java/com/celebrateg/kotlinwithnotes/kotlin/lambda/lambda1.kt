package com.example.issuser.myapplication.kotlin.lambda

/**
 * @Author CelebrateG
 * @Description Lambda 表达式语法
 * lambda 表达式与匿名函数是“函数字面值”，即未声明的函数
 * @Date  2018/11/9
 */

/**
 * 完整语法形式的参数声明放在花括号内
 * 函数体跟在一个 -> 符号之后
 * 返回类型是最后一个表达式
 */
val sum = { x: Int, y:Int -> x + y }

/**
 * 带有可选标注
 */
val sum2 :(Int, Int) -> Int = { x, y -> x + y }


var count = 0
/**
 * 参数未使用，可以用下划线取代其名称
 * Lambda 表达式或者匿名函数（以及局部函数和对象表达式）
 * 可以访问其 闭包 ，即在外部作用域中声明的变量,如 count
 * 与 Java 不同的是可以修改闭包中捕获的变量,java 中往往需要声明为 final
 */
val sum3 = { x: Int,_:Int -> count = x + 3;count }

/**
 * 注意 sum4 返回的并不是 Int，而是 Unit
 */
val sum4  = { x: Int,_:Int -> count = x + 3 }

fun lambda(){
    println(sum(0,1))
    println(sum2(0,2))

    println(count)
    println(sum3(1,100))
    println(count)

    println(sum4(0,5))
}

