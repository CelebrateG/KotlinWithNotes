package com.example.issuser.myapplication.kotlin.classExtends
/**
 * @Author CelebrateG
 * @Description 继承Base类，并覆盖v()，cv()方法
 * @Date 2018/10/19
 */
open class SubClass3 : Base(){

    init {
        println("SubClass3 init")
    }

    override fun v() {
        println("SubClass3.v()")
    }

    /**
     * 禁止子类再次覆盖，或者去掉open标注
     */
    final override fun cv() {
        println("SubClass3.cv()")
    }

    /**
     * 覆盖父类成员，在父类初始化块中使用可能会非正确输出。
     */
    override val x: Int get() = 31
    override var methodsNum: Int = 32
}