package com.celebrateg.kotlinwithnotes.kotlin.other

/**
 * @Author CelebrateG
 * @Description infix 中缀函数:
 * 1、必须是成员函数或扩展函数；
 * 2、必须只有一个参数；
 * 3、其参数不得接受可变数量的参数且不能有默认值
 * @Date  2018/11/23
 */

infix fun Int.myInfix(x:Int):Int{ return x * x }

fun main(args: Array<String>) {
    val a = 1
    a.myInfix(2)
    //等同于
    a myInfix 2

    /**
     * 中缀函数调用的优先级低于算术操作符、类型转换
     * 以及 rangeTo 操作符
     */
    1 myInfix 2 + 3   //1 myInfix (2 + 3)
    0 until 2 * 2 //0 until (2 * 2)

    /**
     * 高于布尔操作符 && 与 ||、is-
     * 与 in- 检测以及其他一些操作符
     */
    2 myInfix 2 in (3..5) //(2 myInfix 2) in (3..5)

    var mi = MyInfix()
    mi.build()
}


/**
 * 当使用中缀表示法在当前接收者上调用方法时，
 * 需要显式使用 this；不能像常规方法调用那样省略。
 */
class MyInfix{
    infix fun add(s:String){
        println(s)
    }
    fun build(){
        this add "abc"
        add("ab")  //正确
//        add "abd" //错误：必须指定接受者
    }
}
