package com.example.issuser.myapplication.kotlin.classEnum
/**
 * @Author CelebrateG
 * @Description 使用 enumValues<T>() 和 enumValueOf<T>()函数
 * 以泛型的方式访问枚举类中的常量
 * @Date  2018/10/24
 */

inline fun <reified T : Enum<T>> printAllValues() {
    //joinToString,根据分隔符分割元素
    print(enumValues<T>().joinToString {
        it.name
    })
}