package com.example.issuser.myapplication.kotlin.classConstructor

/**
 * @Author CelebrateG
 * @Description 派生类有主构造函数，其父类主构造函数有默认参数
 * @Date  2018/10/19
 */

class SubClass3 public constructor(name: String) : Constructor2() {

    init {
        println("SubClass3 init name is:${super.name}")
    }

}