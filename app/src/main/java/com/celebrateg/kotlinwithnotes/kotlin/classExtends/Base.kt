package com.example.issuser.myapplication.kotlin.classExtends

/**
 * @Author CelebrateG
 * @Description 基类
 * 在一个 final 类中（没有用 open 标注的类），开放成员是禁止的。
 * @Date 2018/10/19
 */
open class Base {
    open val x: Int
        get() = 4

    open var methodsNum : Int = 5

    /**
     * 使用了子类覆盖的属性，而子类尚未初始化，有可能导致错误
     * 应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。
     */
    init {
        //错误用法：可能会输出值为 0
        println("this is wrong use $x")
//        println("this is wrong use $methodsNum")
    }

    open fun v() {
        println("Base.v() x = $x")
    }

    /**
     * 无open标注，子类中不允许定义相同签名的函数
     */
    fun nv(){}

    open fun cv() {
        println("Base.cv() x = $x")
    }

}
