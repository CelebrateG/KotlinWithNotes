package com.example.issuser.myapplication.kotlin.classData

/**
 * @Author CelebrateG
 * @Description 数据类
 * 主构造函数需要至少有一个参数
 * 主构造函数的所有参数需要标记为 val 或 var
 * 数据类不能是抽象、开放、密封或者内部的
 * 数据类只能是final的
 * @Date  2018/10/23
 */

/**
 * 编译器会自动的从主构造函数中根据所有声明的属性提取以下函数：
 * equals() / hashCode()
 * toString() 格式如 "User(name=John, age=42)"
 * componentN() functions 对应于属性，按声明顺序排列
 * copy() 函数
 */
data class User(var name: String, var age: Int) {

}