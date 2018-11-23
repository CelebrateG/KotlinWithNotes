package com.example.issuser.myapplication.kotlin.grammer


/**
 * @Author CelebrateG
 * @Description 常量与变量
 * @Date  2018/11/7
 */
fun testStr() {
    //定义常量
    val a: Int
    val b = 2
    a = 1

    //定义变量
    var c = a + b
    println(c)

    //字符串中变量使用
    val s = "c is $c"
    c = a
    val s2 = "${s.replace("is", "was")},but now is $c"
    println(s2)
}

/**
 * NULL检查机制
 */
fun testNull(str: String?) {
    //类型后加?表示可以为null
    val ages = str?.toInt()
    println("ages:$ages")
}

fun testNull2(str: String?) {
    //抛出空指针异常
    val age1 = str!!.toInt()
    println("age1:$age1")
}

fun testNull3(str: String?) {
    //为 null 时返回 -1
    val age2 = str?.toInt() ?: -1
    println("age2:$age2")
}
