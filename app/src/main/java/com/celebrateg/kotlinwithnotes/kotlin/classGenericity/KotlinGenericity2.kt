package com.example.issuser.myapplication.kotlin.classGenericity

/**
 * @Author CelebrateG
 * @Description 类型投影——使用处型变
 * @Date  2018/10/31
 */
fun example(){
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "a" }
    copy(ints, any)
    fill(arrayOf("EZ"),"Viktor")
}

/**
 * from 只能调用 get 方法
 */
fun copy(from: Array<out Any>, to: Array<Any>) {
//    from.set(0,1) //编译会报错
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
        print("${to[i]} ")
    }
}

fun fill(dest: Array<in String>, value: String) {
    dest.set(dest.size - 1,value)
}
