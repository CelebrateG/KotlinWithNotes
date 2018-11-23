package com.example.issuser.myapplication.kotlin.delegationPattern

/**
 * @Author CelebrateG
 * @Description 委托模式:操作的对象不用自己执行，而是把工作委托给另一个辅助对象
 * kotlin 通过 by 关键字将接口实现委托给另一个对象
 * @Date  2018/10/26
 */

interface AnotherInterface{
    val message: String
    fun printSomething()
    fun printMessage()
}

/**
 * 接口实现类
 * 即受委托的类
 */
class Impl(val x : Int) : AnotherInterface{
    override val message = "Impl: x = $x"

    override fun printMessage() {
        println("printMessage: $x")
    }

    override fun printSomething() {
        println("printSomething: $x")
    }
}

/**
 * by 关键字将接口的实现委托给了 i
 * 委托对象 i 为 Derived 的构造参数
 */
class Derived(i : Impl) : AnotherInterface by i

/**
 * 委托给 i 并重写了方法
 */
class Derived2(i : Impl) : AnotherInterface by i{
    //此处调用 i 实现的message属性
    override fun printMessage() {
        println("Derived2.printMessage $message")
    }

}

/**
 * 测试方法
 */
fun testFun(){
    val i = Impl(10)
    Derived(i).printSomething()
    Derived2(i).printMessage()
    println(Derived2(i).message)
}

fun main(args:Array<String>){
    testFun()
}
