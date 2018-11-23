package com.example.issuser.myapplication.kotlin.classExpand

/**
 * @Author CelebrateG
 * @Description 扩展不能真正的修改他们所扩展的类
 * 通过定义一个扩展，你并没有在一个类中插入新成员，
 * 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
 * @Date  2018/10/23
 */

open class C

class D : C()

fun C.foo() = "c"
fun D.foo() = "d"

/**
 * 扩展函数是由函数调用所在的表达式的类型来决定的，
 * 而不是由表达式运行时求值结果决定的，调用的扩展函数只取决于参数( c )的声明类型
 */
fun printFoo(c: C) {
    println(c.foo())
}

/**
 * 扩展属性不能有初始化器
 * 且只能扩展val常量
 */
val C.a: Int
    get() = 1
