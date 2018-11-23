package com.example.issuser.myapplication.kotlin.grammer


/**
 * @Author CelebrateG
 * @Description 条件控制when表达式
 * @Date  2018/10/18
 */

/**
 * when相当于switch语句
 * else 同 switch 的 default
 */
fun useWhenExample1(){
    val x = 10
    when(x){
        0,1 -> println("x is 0 or 1")
        in 1..10 -> println("x is in range from 1 to 10")
        !in 10..20 -> println("x is not in range from 10 to 20")
        else -> println("none of above ")
    }
}

/**
 * 判断参数类型
 */
fun useWhenExample2(){
    println(hasprefix("string type"))
    println(hasprefix(3))
}


/**
 * 不提供参数，所有的分支条件都是简单的布尔表达式
 * 而当一个分支的条件为真时则执行该分支
 * 输出：LGD is in range
 */
fun useWhenExample3(){
    val items = setOf("RNG","EDG","LGD")
    when{
        "SKT" in items -> println("SKT is not in range")
        "LGD" in items -> println("LGD is in range")
        "EDG" in items -> println("EDG is in range")
        "KT" in items -> println("KT is not in range")
    }
}

/**
 * 此时when被作为了表达式使用
 * 当为else分支时，会将值赋给hasprefix函数
 */
fun hasprefix(x : Any) = when(x){
    is String -> println("prefix")
    else -> false
}