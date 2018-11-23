package com.example.issuser.myapplication.kotlin.classConstructor

/**
 * @Author CelebrateG
 * @Description 声明name属性，并有默认值
 * 主构造函数的所有参数都有默认值时，编译器会生成 一个额外的无参构造函数，它将使用默认值
 * @Date 2018/10/19
 */
open class Constructor2(val name: String = "constructorTest2") {

    /**
     * 初始化块
     */
    init {
        println("Constructor2 init Block name:$name")
    }

    /**
     * 次构造函数，委托给另一个构造函数
     * 所有初始化块中的代码都会在次构造函数体之前执行
     * 即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块
     */
    constructor(name: String, name2: String) : this(name2) {
        println("name2:$name2")
    }


}