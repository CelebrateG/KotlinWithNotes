package com.example.issuser.myapplication.kotlin.classGenericity

/**
 * @Author CelebrateG
 * @Description kotlin 声明处型变
 * 消费者 in, 生产者 out
 * @Date  2018/10/30
 */

/**
 * out 型变注解
 * 确保它仅从 Source<T> 成员中返回（生产），并从不被消费。
 * 可以认为 KtSource 是 T 的生产者，而不是 T 的消费者
 */
interface KtSource<out T>{
    fun nextT():T
}

fun demo(ktS : KtSource<String>){
    val objects : KtSource<Any> = ktS
}


/**
 * Comparable 接口中使用了 in 注解
 * 使得一个类型参数逆变:
 * compareTo(other: T)只可以被消费而不可以被生产
 */
fun demo2(c : Comparable<Number>){
    /**
     * Double 是 Number 子类型
     */
    var i : Int = c.compareTo(2.0)
    println(i)

    val y : Comparable<Int> = c
}



