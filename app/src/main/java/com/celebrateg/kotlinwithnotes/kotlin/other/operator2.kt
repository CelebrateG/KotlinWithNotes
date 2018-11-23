package com.example.issuser.myapplication.kotlin.other

/**
 * @Author CelebrateG
 * @Description 重载复合赋值运算符
 * @Date  2018/11/12
 */

/**
 * 当 plus 和 plusAssign 都有定义且使用时
 * 编译器会报错，有两种解决方法：
 * 1、不使用 操作符
 * 2、将 var 替换为 val
 * += 和 -= 在用于可变集合时，始终就地修改（修改原引用）
 * + 和 - 运算符总是返回一个新的集合
 */
fun compoundAssignment2(){
    // 只能定义 numbers 为 val,否则复合赋值运算编译报错
    val numbers = ArrayList<Int>()
    numbers.add(10)
    numbers += 100
    //返回的是一个新的集合
    println(numbers + 20)
    //原集合没有变
    println(numbers)

    // + 同类型集合
    numbers + listOf<Int>(1,2,3)
}

/**
 * += 和 -= 在用于只读集合时，会反返回一个修改过的副本
 * 也意味着 该只读集合的变量只能被声明为 var 才能使用 += 和 -=
 */
fun compoundAssignment3(){
    var numbers2 = listOf<Int>(1,2,3)
    numbers2 += 4
    numbers2 += 5
    println(numbers2 + 6)
    println(numbers2)
}

/**
 * 尽量不要同时给一个类添加 plus 和 plusAssign 运算。
 * 对于 Point 不可变，只需提供返回一个新值的运算 如 plus
 * 对于一个类可变的 如构造器，只需提供如 plusAssign 运算
 */
fun compoundAssignment1(){
    var point = Point(1,2)
    point += Point(3,4)
    println(point)

}