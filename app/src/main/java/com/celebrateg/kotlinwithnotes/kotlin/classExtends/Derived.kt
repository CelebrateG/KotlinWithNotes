package com.example.issuser.myapplication.kotlin.classExtends

/**
 * @Author CelebrateG
 * @Description 抽象类
 * @Date 2018/10/19
 */
abstract class Derived : Base(){
    /**
     * 用一个抽象成员覆盖一个非抽象的开放成员
     */
    abstract override fun v()

    fun caller(b : Base){
        b.v()
    }
}