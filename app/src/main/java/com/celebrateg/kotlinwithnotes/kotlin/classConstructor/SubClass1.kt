package com.example.issuser.myapplication.kotlin.classConstructor

/**
 * @Author CelebrateG
 * @Description
 * 派生类有主构造函数，其基类型可以（并且必须） 用基类的主构造函数参数就地初始化
 * @Date 2018/10/19
 */
class SubClass1 public constructor(name: String) : Constructor1(name) {

    /**
     * 会先调用父类的初始化块
     */
    init {
        println("SubClass1 name is : $name")
    }


}