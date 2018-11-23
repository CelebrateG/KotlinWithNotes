package com.example.issuser.myapplication.kotlin.delegationPattern

import kotlin.reflect.KProperty


/**
 * @Author CelebrateG
 * @Description 委托属性
 * @Date  2018/10/26
 */

/**
 * 通过 by 关键字编译器会自动生成一个辅助属性 val delegate = Delegate()
 * p 的访问都会调用对应 delegate 的 getValue 和 setValue 方法
 */
class Example {
    var p: String by Delegate()
}

/**
 * 属性的委托不必实现任何的接口，
 * 但是需要提供一个 getValue() 函数
 * 即将访问器的逻辑委托给一个辅助对象
 * (与 setValue()函数——对于 var 属性)
 * 两函数都需要用 operator 关键字来进行标记
 */
class Delegate{
    /**
     * thisRef 必须与属性所有者类型（对于扩展属性——指被扩展的类型）相同
     * 或者是它的超类型
     * property 必须是类型 KProperty<*> 或其超类型
     * 函数必须返回与属性相同的类型（或其子类型）
     */
    operator fun getValue(thisRef : Any?,property : KProperty<*>):String{
        return "thisRef:$thisRef ,property:'${property.name}'"
    }

    /**
     * thisRef,property同上
     * value 必须与属性同类型或者是它的超类型
     */
    operator fun setValue(thisRef : Any?,property : KProperty<*>,value : String){
        println("value:${value.toString()},property:'${property.name}',thisRef:${thisRef.toString()}")
    }

}


/**
 * 自 Kotlin 1.1 起也可以在函数
 * 或代码块中声明一个委托属性
 */
fun aFun(){
    var name : String by Delegate()
    name = "aFun"
    println(name)
}

