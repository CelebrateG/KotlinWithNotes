package com.example.issuser.myapplication.kotlin.classExtends
/**
 * @Author CelebrateG
 * @Description 同时继承Ｂase和InterfaceA
 * 解决覆盖冲突
 * @Date 2018/10/19
 */
class SubClass2 : Base(),InterfaceA{
    /**
     * 编译器要求覆盖 v(),因为两个超类中都有v()
     * 然后可以重新实现该方法
     */
    override fun v() {
//        super<Base>.v()
//        super<InterfaceA>.v()
        println("SubClass2:v()")
    }

    init{
        println("SubClass2 init")
    }
}