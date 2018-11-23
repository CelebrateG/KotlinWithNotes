package com.example.issuser.myapplication.kotlin.classExpand

/**
 * @Author CelebrateG
 * @Description 扩展声明为成员
 * @Date  2018/10/23
 */

/**
 * Q为扩展接受者
 */
class Q {
    fun bar() {
        println("Q bar()")
    }
    //与W相同函数
    fun box(){
        println("Q box()")
    }
}

/**
 * W分发接受者
 */
class W {
    fun baz() {
        println("W baz()")
    }
    fun box(){
        println("W box()")
    }
    fun Q.foo() {
        bar()
        baz()
        //相同函数时，调用Q的box()
        box()
        //使用this,调用分发者的函数
        this@W.box()
    }
    fun caller(q : Q){
        q.foo()
    }
}