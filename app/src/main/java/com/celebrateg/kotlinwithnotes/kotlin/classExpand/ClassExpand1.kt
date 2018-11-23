package com.example.issuser.myapplication.kotlin.classExpand

/**
 * @Author CelebrateG
 * @Description 扩展
 * @Date  2018/10/22
 */

/**
 * 这个 this 关键字在扩展函数内部对应到接收者对象（传过来的在点符号前的对象）
 * 现在，我们对任意 MutableList<Int> 可以调用该函数
 */
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}


/**
 * 为可空的接收者类型定义扩展
 */
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

