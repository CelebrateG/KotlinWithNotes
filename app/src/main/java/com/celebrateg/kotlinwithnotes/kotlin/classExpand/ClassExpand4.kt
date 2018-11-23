package com.example.issuser.myapplication.kotlin.classExpand

/**
 * @Author CelebrateG
 * @Description 伴生对象的扩展
 * 伴生对象可参见ClassObject5
 * @Date  2018/10/23
 */

class MyClass {
    companion object {
        val innerName = "inner name"
        var id = 0
        /**
         * 伴生对象中的函数无法调用类内部的扩展函数
         */
        fun companionFun1() {
            println("this is 1st companion function.")
            //调用外部的foo()，无法调用内部的foo2()
//            foo2()
            foo()
        }
    }

    var id = 1

    /**
     * 类内的其它函数优先引用伴生对象内部的扩展函数
     */
    fun bar() {
        print("bar()")
        //优先调用内部的foo()
        foo()
        foo2()
        foo3()
    }

    /**
     * 伴生对象内部的foo()
     */
    fun MyClass.Companion.foo() {
        println("伴生对象内部的foo()")
    }

    /**
     * 伴生对象内部的foo2()
     * 不能被外部引用
     * 也不能被companion object{}内引用
     */
    fun MyClass.Companion.foo2() {
        println("伴生对象内部的foo2()")
    }

}

/**
 * 伴生对象外部的foo()
 */
fun MyClass.Companion.foo() {
    println("伴生对象外部的foo()")
}

/**
 * 伴生对象外部的foo3()
 */
fun MyClass.Companion.foo3() {
    println("伴生对象外部的foo3()")
}
/**
 * 伴生对象扩展属性
 */
val MyClass.Companion.name
    get() = "out name"
