package com.example.issuser.myapplication.kotlin.delegationPattern

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @Author CelebrateG
 * @Description 提供委托
 * by 右侧所使用的对象将 provideDelegate 定义为成员或扩展函数，
 * 那么会调用该函数来创建属性委托实例
 * @Date  2018/10/29
 */

/**
 * 继承 ReadOnlyProperty 接口，实现 getValue 方法
 * 可以看出 getValue 已被标记为 operator
 */
class ResourceDelegate : ReadOnlyProperty<MyUI, String> {
    //这里简单的把属性返回值设置成了属性名称
    override fun getValue(thisRef: MyUI, property: KProperty<*>): String {
        return property.name
    }
}

/**
 * 定义受委托的类
 * 可以看出 provideDelegate 函数最终返回的是 getValue 方法的值
 * 可以在 provideDelegate 函数中进行一些操作，比如检查属性一致性，之后返回属性值
 * 可以理解为属性在获取值之前在此处进行了拦截
 */
class ResourceLoader(id: ResourceID) {
    val d: ResourceID = id
    operator fun provideDelegate(thisRef: MyUI, prop: KProperty<*>): ReadOnlyProperty<MyUI, *> {
        checkProperty(thisRef, prop.name)
        return ResourceDelegate()
    }

    private fun checkProperty(thisRef: MyUI, name: String){
        //由于 provideDelegate 方法是在创建 MyUI 实例期间调用，这里使用实例的属性会出现空指针异常
//        println("thisRef: ${thisRef.text}")
        println("check property: $name")
    }
}

fun bindResource(id: ResourceID): ResourceLoader {
    var res = ResourceLoader(id)
    return res
}

/**
 * 在创建 MyUI 实例期间，
 * 会为每个属性调用 provideDelegate 方法
 */
class MyUI {
    val text by bindResource(ResourceID())
    val image by bindResource(ResourceID())
    val button by bindResource(ResourceID())
}

class ResourceID

fun main(args: Array<String>) {
    var ui = MyUI()
}