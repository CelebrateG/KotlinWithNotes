package com.example.issuser.myapplication.kotlin.classConstructor


/**
 * @Author CelebrateG
 * @Description 主构造函数默认可见性是 public
 * 如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面
 * open 关键字表示可被其他类继承，默认是final不能被继承
 * @Param name 主构造器参数
 * @Date  2018/10/19
 */
open class Constructor1 constructor(name: String) {
    /**
     * 初始化块，只能使用主构造器中参数
     */
    init {
        println("Constructor1 init block name:$name")
    }

    /**
     * 次构造函数，每个次构造函数都要直接或间接代理主构造函数
     * 所有初始化块中的代码都会在次构造函数体之前执行
     * 即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块
     */
    constructor(name: String, name2: String) : this(name) {
        println("Constructor1 name:$name,name2:$name2")
    }

    /**
     * 次构造函数，委托给另一个次构造函数
     * 会先调用委托的构造函数
     */
    constructor(name: String, name2: String, age: Int) : this(name, name2) {
        println("Constructor1 name:$name,name2:$name2,age:$age")
    }

    /**
     * 初始化属性
     */
    private var nikeName = name

    fun printInfo(){
        println("Constructor1 nikeName : $nikeName")
    }

}