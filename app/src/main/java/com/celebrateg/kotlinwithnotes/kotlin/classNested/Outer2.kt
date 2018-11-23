package com.example.issuser.myapplication.kotlin.classNested

/**
 * @Author CelebrateG
 * @Description 内部类
 * 内部类使用 inner 关键字来表示。
 * @Date  2018/10/19
 */

class Outer2:OuterBase(){
    private val bar: Int = 10
    var v = "成员属性"

    /**
     * 内部类会带有一个对外部类的对象的引用，
     * 所以内部类可以访问外部类成员属性和成员函数。
     */
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            var o = this@Outer2 //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)

            super@Outer2.out() //调用OuterBase.out
            println("inner print: ${super@Outer2.x}")//OuterBase.x
        }
    }

}