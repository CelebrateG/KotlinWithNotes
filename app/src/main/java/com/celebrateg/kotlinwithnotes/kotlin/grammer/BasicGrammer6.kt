package com.example.issuser.myapplication.kotlin.grammer

import java.util.*

/**
 * @Author CelebrateG
 * @Description 数组
 * @Date  2018/11/7
 */
fun testArray() {
    var a = arrayOf(1, 2, 3)
    //相当于序号 * 1
    var b = Array(3, { i -> i * 1 })
    println("${a.get(0)},${a.get(1)},${a.get(2)}")
    println("${b.get(0)},${b.get(1)},${b.get(2)}")

    //Int 类型数组，省去了装箱操作，因此效率更高
    var c: IntArray = intArrayOf(1, 2, 3)
    c[0] = c[1] + c[2]

    /**
     * 伸展（spread）操作符（在数组前面加 *）
     */
    val list = Arrays.asList(-1,0,*a,4)

}