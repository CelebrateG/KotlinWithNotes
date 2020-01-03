package com.celebrateg.kotlinwithnotes.kotlin.reflect

import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.javaField

class TestReflect {

    fun setManValue() {
        var man = Man()
        var ironMan = IronMan(10.1, "age")
//        man.javaClass.kotlin
        var manClazz = man.javaClass.kotlin

        manClazz.memberProperties.forEach {
            if (it.name == ironMan.fieldName) {
                it.isAccessible = true
                if (it.javaField != null) {
                    println("type:${it.javaField!!.type}")
                    if (it.javaField!!.type == Double::class.java) {
                        it.javaField!!.set(man, ironMan.param)
                    } else if (it.javaField!!.type == Integer::class.java) {
                        //注意这里是Integer，不能是Int
                        it.javaField!!.set(man, ironMan.param!!.toInt())
                    }
                }
            }
        }
        println(man.toString())
    }

}

fun main() {
    TestReflect().setManValue()
}