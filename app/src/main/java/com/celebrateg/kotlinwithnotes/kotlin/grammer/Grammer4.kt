package com.celebrateg.kotlinwithnotes.kotlin.grammer

/**
 * @Author CelebrateG
 * @Description apply、let、with、run、also
 * @Date  2019/1/8
 */

/**
 * 可以看出 apply 参数中的匿名函数的返回值为 Unit，即无返回值；
 * 且该匿名函数是 T 类型对象调用的，所以在 apply 函数体中（实现该匿名函数时）
 * 可直接调用该对象内部方法；
 * this 即代表当前引用对象，可省略
 * apply 最后返回调用它的 T 类型对象
 */
fun UseApply(){
    val list:MutableList<String> = mutableListOf("A","B","C")
    val change:Any
    change = list.apply {
        add("D")
        add("E")
        add("F")
        size
    }
    println("apply--------------------")
    println("list = $list")
    println("change = $change")
}

/**
 * 可以看出 let 参数中的匿名函数,其中 T 类型对象是该匿名函数的一个参数，
 * 所以在 let 函数体中，it 表示参数，即引用对象,
 * 调用其方法时，it 不可省略，
 * lambda 表达式（匿名函数）最后一句为返回值，同时也是 let 的返回值，
 * 返回类型是 R（R可以是 Unit,即无返回值）；
 */
fun UseLet(){
    val list:MutableList<String> = mutableListOf("A","B","C")
    val change:Any
    //list 不为 null 时执行函数体
    change = list?.let {
        it.add("D")
        it.add("E")
        it.size
    }
    println("let--------------------")
    println("list = $list")
    println("change = $change")
}

/**
 * with 第一个参数是 T 类型对象，第二个参数是该对象的匿名函数
 * 所以在 with 函数体中可直接调用对象内部的函数
 * lambda 表达式最后一句为返回值，同时也是 with 的返回值
 * 返回类型是 R（R可以是 Unit,即无返回值）
 */
fun UseWith(){
    val list:MutableList<String> = mutableListOf("A","B","C")
    val change:Any
    change = with(list){
        add("D")
        add("E")
        size
    }
    println("with--------------------")
    println("list = $list")
    println("change = $change")
}

/**
 * run 参数是 T 类型对象的匿名函数，
 * 所以在 run 函数体中可直接调用对象内部的函数，
 * lambda 表达式最后一句为返回值，同时也是 run 的返回值，
 * 返回类型是 R（R可以是 Unit,即无返回值）
 */
fun UseRun(){
    val list:MutableList<String> = mutableListOf("A","B","C")
    val change:Any
    change = list.run {
        add("D")
        add("E")
        size
    }
    println("run--------------------")
    println("list = $list")
    println("change = $change")
}

/**
 * also 参数中的匿名函数,其中 T 类型对象是该匿名函数的一个参数，
 * 所以在 let 函数体中，it 表示参数，即引用对象,
 * 调用其方法时，it 不可省略，
 * lambda 返回类型是 Unit,即无返回值，
 * also 最后返回调用它的 T 类型对象
 */
fun UseAlso(){
    val list:MutableList<String> = mutableListOf("A","B","C")
    val change:Any
    change = list.also {
        it.add("D")
        it.add("E")
        it.size
    }
    println("also--------------------")
    println("list = $list")
    println("change = $change")
}
