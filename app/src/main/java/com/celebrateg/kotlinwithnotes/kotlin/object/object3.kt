package com.example.issuser.myapplication.kotlin.`object`

import com.example.issuser.myapplication.kotlin.classNested.AnInterface
import com.example.issuser.myapplication.kotlin.classNested.Outer3


/**
 * @Author CelebrateG
 * @Description 匿名内部类
 * @Date  2018/10/25
 */

/**
 * 对象表达式中的代码可以访问来自包含它的作用域的变量
 */
fun countClicks() {
    var count = 0
    var out3 = Outer3()
    out3.setInterface(object : AnInterface {
        override fun aMethod() {
            println(++count)
        }
    })
}