package com.example.issuser.myapplication.kotlin.classGenericity

/**
 * @Author CelebrateG
 * @Description 型变
 * @Date  2018/10/24
 */

/**
 * 声明处的类型变异使用协变注解修饰符：in、out
 * 消费者 in, 生产者 out。
 * out 使得一个类型参数协变
 * 协变类型参数只能用作输出，可以作为返回值类型，以及成员变量类型
 * 但是无法作为入参的类型，就是说成员函数中参数类型不可以为 A
 */
class Runoob<out A>(val a : A){
    fun foo() : A{
        return a
    }

}


/**
 * in 使得一个类型参数逆变
 * 逆变类型参数只能用作输入，可以作为入参的类型
 * 但是无法作为返回值的类型
 * 无法作为成员变量类型
 */
class Runooa<in A>{
    fun foo(a : A){
        println("A 无法作为返回值的类型 a：$a")
    }
}