package com.example.issuser.myapplication.kotlin.other

import com.example.issuser.myapplication.kotlin.grammer.sum
import kotlin.reflect.full.memberProperties

/**
 * @Author CelebrateG
 * @Description kotlin 反射
 * 动态的访问对象的属性和方法的方式，而不需要事先确定这些属性是什么
 * 使用 Java 反射库的 API 完全兼容 Kotlin 代码
 * Kotlin 反射 API 也并不仅限于 Kotlin 类，可以是任何 JVM 语言写的类
 * @Date  2018/11/13
 */

/**
 * 使用 KClass
 * 打印类名称和属性名称
 */
fun reflect1() {
    val player1 = Player("KoBe", "Bryant")
    //返回一个 KClass<Player> 实例
    val kclass = player1.javaClass.kotlin
    // 得到一个 KClass<out Player> 实例，只能作为输出
    var kclass2 = player1::class
    println(kclass.memberProperties.map {
        "${it.name}:${it.get(player1)}"
    }.joinToString {
        //        println(it)
        "1"
    })
    var list = arrayListOf<String>("1", "1")
    println(list)
    kclass2.memberProperties.forEach { println(it.name) }
}

fun foo(x: Int) {
    println(x)
}

/**
 * 利用反射 KFunction 的 call 方法调用 foo 函数
 * 参数没有校验，可能会出现运行时异常
 */
fun fooTest() {
    val kf = ::foo
//    kf.call("lalalala") //会造成运行时异常
    kf.call(100)
}


/**
 * 优先使用反射 KFunction 的具体参数方法 invoke
 * 可以发现,我们无法找到 invoke 的声明,这被称为
 * 合成的编译器生成类型,意味着可以利用反射使用任意数量参数的函数接口
 */
fun kfInvokeUse() {
    val kFunction = ::sum
    val kFunction2 = ::foo
    println(kFunction.invoke(1, 1))
    kFunction2.invoke(200)
}


/**
 * KProperty使用
 */
var counter = 0

fun kPUse() {
    val kProperty = ::counter
    kProperty.set(121)
    println(kProperty.get())

    var counter1 = 1
//    val kProperty = ::counter1 //不能通过反射访问函数局部变量
}


/**
 * 成员属性通过反射 Kproperty 的 get(T) 动态获取
 */
fun memberKPUse() {
    val player = Player("Iverson", "3")
    var memberProperties = Player::firstName
    println(memberProperties.get(player))
}
