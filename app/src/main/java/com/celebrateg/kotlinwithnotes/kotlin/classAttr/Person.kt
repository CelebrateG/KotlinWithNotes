package com.example.issuser.myapplication.kotlin.classAttr

//编译期常量
//const val SUBSYSTEM_DEPRECATED : String = "This subsystem is deprecated"
/**
 * @Author CelebrateG
 * @Description Person实体类
 * @Date  2018/10/18
 */
class Person {
    /**
     * 此自定义访问器存在递归调用，即name = value,事实上又调用了set(value)方法。
     * 转换成java代码，就是setName(String name){setName(name)}
     * getName(){return this.getName()}
     * 在调用时会出现StackOverflowError
     */
    var name: String
        set(value) {
            name = value
        }
        get() = name

    /**
     * 访问器的默认实现，或者自定义访问器通过 field 引用幕后字段
     * 将会为该属性生成一个幕后字段。
     */
    var brothers = 3
    var age: Int = 9
        set(value) {
            if (value > 10) {
                field = value
            } else
                field = -value
        }

    val hasBrothers: Boolean
        get() = this.brothers == 0

    /**
     * 默认访问器，此处如果不初始化，则需要在构造器中初始化
     */
    val id: Int

    constructor(id: Int) {
        this.id = id
    }

    /**
     * 改变一个访问器的可见性或者对其注解，但是不需要改变默认的实现
     */
    var gender: Int = 1
        private set
}