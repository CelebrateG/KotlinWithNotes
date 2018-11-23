package com.example.issuser.myapplication.kotlin.classInterface

/**
 * @Author CelebrateG
 * @Description 接口实现类
 * @Date  2018/10/22
 */
class Child : MyInterface{

    override var name: String = "child"

    override fun bar() {
        println("child bar")
    }

    override fun foo() {
        super.foo()
        println("child : foo()")
    }

}