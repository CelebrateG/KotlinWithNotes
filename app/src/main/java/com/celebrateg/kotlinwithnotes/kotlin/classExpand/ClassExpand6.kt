package com.example.issuser.myapplication.kotlin.classExpand

/**
 * @Author CelebrateG
 * @Description 成员形式的扩展函数的继承与重写
 * @Date  2018/10/23
 */

/**
 * 扩展接收者类型
 */
open class J {
}
class J1 : J(){
}

/**
 * 分发接收者
 */
open class K{
    /**
     * 扩展函数被声明为open
     * 可以在子类中覆盖
     */
    open fun J.foo(){
        println("J.foo() in K")
    }
    open fun J1.foo(){
        println("J1.foo() in K")
    }
    fun caller(j : J){
        //调用扩展函数
        j.foo()
    }
}

/**
 * 这些函数的分发对于分发接收者类型是虚拟的，
 * 但对于扩展接收者类型是静态的
 */
open class K1 : K(){
    override fun J.foo(){
        println("J.foo() in K1")
    }
    override fun J1.foo(){
        println("J1.foo() in K1")
    }
}
