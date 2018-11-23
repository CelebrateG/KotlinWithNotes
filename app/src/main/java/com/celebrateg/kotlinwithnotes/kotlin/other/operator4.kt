package com.example.issuser.myapplication.kotlin.other

/**
 * @Author CelebrateG
 * @Description 重载比较运算符
 * @Date  2018/11/12
 */
fun equalOperator1(a:Int?){
    var b = null
    println(a == b)
    //相当于 a == b,可用于可空运算数
    println(a?.equals(b) ?: (b == null))
}

open class Circle(val x: Int, val y: Int){
    /**
     * 不需要标记 operator，因为 Any 类已经标记了
     * 函数中的 operator 修饰符适用于所有被实现或重写的方法
     * equals 不能实现为扩展函数，因为继承自 Any 类的实现优于扩展函数
     * 即扩展函数与成员函数同名时，优先调用成员函数
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Circle) return false
        return x == other.x && y == other.y
    }
}

/**
 * 重写 equals 方法
 */
class Oval(x:Int,y: Int):Circle(x,y){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Oval) return false
        return x == other.x && y == other.y
    }
}

fun equalOperator2(){
    var circle1 = Circle(0,0)
    var circle2 = Circle(2,2)
    var circle3 = Circle(0,0)
    var oval1 = Oval(1,2)
    var oval2 = Oval(3,2)

    println(circle1 == circle2)
    println(circle1 == circle3)
    println(oval1 == oval2)
}

