package com.example.issuser.myapplication.kotlin.other

/**
 * @Author CelebrateG
 * @Description 集合
 * @Date  2018/11/12
 */

/**
 * 可变集合与不可变集合
 */
fun setFun1(){
    //改变 list 的方法是由 MutableList<T> 加入的
    val numbers : MutableList<Int> = mutableListOf(1,2,3)
    //List<out T> 类型是一个提供只读操作的接口
    val readOnlyView:List<Int> = numbers

    println(numbers)
//    readOnlyView.clear()    // -> 不能编译

    numbers.add(4)
    //readOnlyView 与 numbers 引用相同
    println(readOnlyView)


    // HashSet 继承了 MutableSet
    val strings = hashSetOf("a", "b", "c", "c")
    assert(strings.size == 3)

}

/**
 * list 使用
 */
fun setFun2(){
    //创建一个只读引用
    val items = listOf<Int>(1,2,3,4)

    println(items.first())  //输出 1
    println(items.last())   //输出 4
    println(items.filter { it % 2 == 0 }) //输出 [2,4]

    val list2 = mutableListOf(1,2,3)
    println(list2.requireNoNulls())

    if (list2.none{it > 6}) println("no items above 6")
    val item = list2.firstOrNull()
    println(item)
}

/**
 * Map 使用
 */
fun setFun3(){
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])  // 输出“1”
    val snapshot: Map<String, Int> = HashMap(readWriteMap)
}

/**
 * Map 使用
 */
fun setFun4(){

}
