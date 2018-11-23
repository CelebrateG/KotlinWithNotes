package com.example.issuser.myapplication.kotlin.classConstructor

/**
 * @Author CelebrateG
 * @Description 派生类无主构造函数
 * @Date 2018/10/19
 */
class SubClass2 : Constructor1 {

    init {
        println("SubClass2 init")
    }

    constructor(name: String) : super(name) {
        println("SubClass2 name:$name")
    }

    /**
     * 委托调用父类构造方法
     */
    constructor(name: String, name2: String) : super(name, name2) {
        println("SubClass2 name:$name name2:$name2")
    }

}