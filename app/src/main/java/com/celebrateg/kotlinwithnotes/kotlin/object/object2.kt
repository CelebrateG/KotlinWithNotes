package com.example.issuser.myapplication.kotlin.`object`

/**
 * @Author CelebrateG
 * @Description 对象表达式:匿名对象
 * @Date  2018/10/25
 */

/**
 * 函数或属性，该函数或属性实际类型是匿名对象声明的超类型
 * 若没有声明超类型，就是Any
 */
class M{
    /**
     * 私有函数，其返回类型是匿名对象类型
     * 类型是 Any
     */
    private fun foo() = object{
        val x : String = "x"
    }

    /**
     * 类型是 A
     */
    private var stu = object : A(3){
        var game = "battleField"
    }

    /**
     * 类型是 Any
     */
    fun foo2() = object {
        val name = "Uzi"
    }

    /**
     * 返回类型是 A
     */
    var tea = object : A(30){
        val book = "math"
    }

    /**
     * 可以访问到声明为私有的成员
     * 无法解析公有的成员
     */
    fun bar(){
        println(stu is A)
        println(tea is A)
        println(foo() is Any)
//        println(foo() is A) //编译报错，不兼容类型
        println(foo2() is A)

        println(foo().x)
        println(stu.game)
//        println(foo2().name) //编译报错，无法解析公有的成员
//        println(tea.book)  //编译报错，无法解析公有的成员
    }

}