package com.example.issuser.myapplication.kotlin.classNested

/**
 * @Author CelebrateG
 * @Description 嵌套定义的类，但不是内部类
 * @Date  2018/10/19
 */
class Outer(){
    private val bar = 1
    val id = 0

    /**
     * 该类无法直接访问到外部类成员
     * 访问方式和普通类一样
     */
    class Nested(){
        fun foo() = 1
    }
}