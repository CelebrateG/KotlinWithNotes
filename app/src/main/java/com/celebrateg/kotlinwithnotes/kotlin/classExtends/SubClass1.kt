package com.example.issuser.myapplication.kotlin.classExtends

/**
 * @Author CelebrateG
 * @Description 在主构造器中，直接覆盖父类成员
 * @Date 2018/10/19
 */
class SubClass1(override var methodsNum: Int) : SubClass3(){

    init {
        println("SubClass1 init")
    }

    override fun v() {
        println("SubClass1 v()")
    }


}