package com.example.issuser.myapplication

import com.example.issuser.myapplication.kotlin.other.Player
import org.junit.Rule
import org.junit.Test

/**
 * @Author CelebrateG
 * @Description 注解目标
 * 使用点目标 声明用来说明要注解的元素
 * @Date  2018/11/16
 */
class LOLTeam2{
//    @Rule //错误用法，会出现：The @Rule 'member1' must be public.
    val member1 = Player("IG","ning")

    /**
     * 使用点目标的语法
     * get 使注解应用到属性的 getter 上
     */
    @get:Rule
    val member2 = Player("IG","the shy")

    /**
     * 把属性暴露成一个没有访问器的公有java字段
     */
    @JvmField
    val from = "LPL"


    @Test
    fun test(){
        println(member1.lastName)
        println(member2.lastName)
        println(from)
    }
}