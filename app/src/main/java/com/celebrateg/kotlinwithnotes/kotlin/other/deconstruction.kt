package com.example.issuser.myapplication.kotlin.other

import com.example.issuser.myapplication.kotlin.classData.User

/**
 * @Author CelebrateG
 * @Description 解构声明
 * 把一个对象解构成很多变量
 * 变量数量需要和对象构造函数声明属性的数量相对应
 * 仅允许局部变量/值使用析构函数声明。
 * @Date  2018/11/12
 */

var user = User("the shy",18)
fun deconstruction(){
    val (name,age) = user
    println("name:$name,age:$age")

}

/**
 * 如果解构声明中不需要某个变量，可以用下划线取代其名称
 * 不会调用相应的 componentN() 操作符函数
 */
fun deconstruction2(){
    val (_,age) = user
}


var map = mapOf<String,Int>("Kobe" to 24,"Lebro" to 23,"Jordan" to 23)
/**
 * 解构声明和映射(map)
 */
fun deconstruction3(){
    for ((key,value) in map){
        println("key:$key,value:$value")
    }
}
/**
 *  lambda 表达式中解构
 */
fun deconstruction4(){
    /**
     * map.mapValues 返回一个具有原来key，
     * value需要该函数处理的新的 map
     */
    var newMap1 = map.mapValues { entry -> "${entry.value} " }
    var newMap2 = map.mapValues { (key, value) -> "#$value#" }

    println(newMap1)
    println(newMap2)
}