package com.example.issuser.myapplication.kotlin.delegationPattern

/**
 * @Author CelebrateG
 * @Description 局部委托属性
 * @Date  2018/10/26
 */
class Fisherman{
    fun fishing():Any{
        val words = "fisherMan is fishing"
        println(words)
        return words
    }
}
fun fishing(): Fisherman {
    println("create Fisherman")
    return Fisherman()
}

fun partialDelegation(computeFoo:()->Fisherman){
    val memoziedA by lazy{fishing()}
    var x = 30
    //memoziedA 变量只会在第一次访问时计算
    memoziedA
    if (x > 50 && memoziedA.fishing() is Number){
        println("当X < 50，该变量不会计算")
    }
}