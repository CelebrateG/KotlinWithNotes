package com.example.issuser.myapplication.kotlin.other

/**
 * @Author CelebrateG
 * @Description 操作符重载(二元操作符)
 * 重载操作符的函数需要用 operator 修饰符标记
 * @Date  2018/11/9
 */

data class Point(val x: Int, val y: Int){
    /**
     * 重载二元操作符 +
     * 使两个点坐标相加
     */
    operator fun plus(other : Point):Point{
        return Point(x + other.x,y + other.y)
    }
}

/**
 * 通过扩展函数重载二元操作符 *
 * 使一个点在坐标系中缩放
 * 可以看出重载之后操作符不支持交换性，
 * 因为第二个参数是 Point 类型
 */
operator fun Point.times(times : Double) : Point {
    return Point((x * times).toInt(),(y * times).toInt())
}

/**
 * 重载 Double 操作符
 * 实现 double * point
 */
operator fun Double.times(p : Point) : Point {
    return Point((p.x * this).toInt(),(p.y * this).toInt())
}


fun testOperator() {
    val point = Point(10, 20)
    println(point + Point(2,4))

    println(point * 0.3)
    println(0.3 * point)
}