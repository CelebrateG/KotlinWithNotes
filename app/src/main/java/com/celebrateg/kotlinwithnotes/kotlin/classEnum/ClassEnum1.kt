package com.example.issuser.myapplication.kotlin.classEnum

/**
 * @Author CelebrateG
 * @Description 枚举类
 * @Date  2018/10/24
 */

enum class Color1{
    RED,BLACK, BLUE,YELLOW,WHITE,GREEN,PINK
}

/**
 * 每一个枚举都是枚举类的实例
 * 声明构造函数及属性 rgb
 */
enum class Color2(val rgb:Int){
    RED(1000),
    GREEN(2000),
    BLUE(3000)
}


enum class Shape(value : Int){
    OVAL(100),
    RECTANGLE(200)
}
