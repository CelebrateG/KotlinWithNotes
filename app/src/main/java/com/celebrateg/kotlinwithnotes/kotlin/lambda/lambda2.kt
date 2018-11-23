package com.example.issuser.myapplication.kotlin.lambda

/**
 * @Author CelebrateG
 * @Description 函数类型实例化
 * 有以下方式：
 * 1、lambda表达式
 * 2、匿名函数
 * 3、已有声明的可调用引用
 * 4、实现函数类型接口的自定义类的实例
 * @Date  2018/11/8
 */
//1、（参数）-> 返回值
val lambdaB : (Int, Int) -> Int = { x, y -> x + y }


//2、匿名函数
val funA =  fun (s:String):Int{return s.toIntOrNull() ?: 0}


//4、该类实现 lambda 表达式的接口
class IntTransformer:(Int) -> Int{
    override fun invoke(p1: Int): Int {
        return p1
    }
}
//intFunctionA 与 intFunctionB 都相当于调用 invoke 函数
var intFunctionA :(Int) -> Int = IntTransformer()
var intFunctionB = IntTransformer()


fun testFunction(){
    var b1 = intFunctionA(2)
    var b2 = intFunctionB(2)
    lambdaB(1,2)
    funA("lalala")
    println("b1:$b1,b2:$b2")
}
