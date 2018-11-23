package com.example.issuser.myapplication.kotlin.`object`

import com.example.issuser.myapplication.kotlin.classNested.AnInterface

/**
 * @Author CelebrateG
 * @Description 对象声明
 * 对象声明是在第一次被访问到时延迟初始化的；
 * 总是在 object 关键字后跟一个名称
 * 对象声明不是一个表达式，不能用在赋值语句的右边
 * 对象声明不能在局部作用域（即直接嵌套在函数内部），
 * 但是它们可以嵌套到其他对象声明或非内部类中。
 * @Date  2018/10/25
 */
object NetBarManager{
    fun registerLeaguer(){
        println("注册会员")
    }

}

/**
 * 继承超类的对象
 */
object LOLTeam : AnInterface {
    override fun aMethod() {
        println("LOLTeam : RNG")
    }
}