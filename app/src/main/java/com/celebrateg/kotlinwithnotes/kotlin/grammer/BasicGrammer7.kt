package com.example.issuser.myapplication.kotlin.grammer


/**
 * @Author CelebrateG
 * @Description === 与 ==
 * @Date  2018/11/7
 */
fun comparNumber(a: Int) {
    var boxA: Int? = a
    var boxB: Int? = a
    //比较两个对象的地址,在范围是 [-128, 127] 之间并不会创建新的对象
    println(boxA === boxB)
    //比较两个对象值
    println(boxA == boxB)
}

fun anotherCompare(a: Int) {
    //不显示声明类型不会封装新对象
    var boxA = a
    var boxB = a
    println(boxA === boxB)
}