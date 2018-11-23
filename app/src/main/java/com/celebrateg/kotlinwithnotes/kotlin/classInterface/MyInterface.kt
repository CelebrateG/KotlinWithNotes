package com.example.issuser.myapplication.kotlin.classInterface

/**
 * @Author CelebrateG
 * @Description 接口
 * @Date  2018/10/22
 */
interface MyInterface {
    /**
     * name 属性必须抽象的
     * 子类必须实现
     */
    var name:String

    /**
     * 子类必须实现的方法
     */
    fun bar()

    /**
     * 子类可不实现
     */
    fun foo() {
        println("foo")
    }
}