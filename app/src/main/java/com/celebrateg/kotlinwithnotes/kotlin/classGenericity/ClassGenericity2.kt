package com.example.issuser.myapplication.kotlin.classGenericity

/**
 * @Author CelebrateG
 * @Description 泛型约束
 * @Date  2018/10/24
 */

/**
 * 冒号之后指定的类型是上界
 * 只有 Comparable<T> 的子类型可以替代 T
 */
fun <T : Comparable<T>> constraint(list: List<T>) {
    for (i in list) {
        println(i)
    }
}

/**
 * 同一类型参数需要多个上界，
 * 需要一个单独的 where-子句
 */
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}
