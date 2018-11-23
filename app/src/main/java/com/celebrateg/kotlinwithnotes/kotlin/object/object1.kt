package com.example.issuser.myapplication.kotlin.`object`

/**
 * @Author CelebrateG
 * @Description 对象表达式
 * 对象表达式是在使用他们的地方立即执行（及初始化）的；
 * 对象表达式中 object 后面不能加名字
 * @Date  2018/10/24
 */

/**
 * object简单使用
 */
fun simpleUseObj(){
    var name = "simple"
    /**
     * 相当于临时定义了一个类
     */
    val aObj = object {
        var x : Int = 0
        var y : Int = 0
        fun useAttr(){
            print(name)
            name = "aObj"
            println(" $name")
        }
    }
    println(aObj.x + aObj.y)
    aObj.useAttr()
}


/**
 * 同时继承A、B的对象
 */
open class A(x:Int){
     open val y = x
}
interface B

val ab : A = object : A(1),B{
    override val y = 10
}
