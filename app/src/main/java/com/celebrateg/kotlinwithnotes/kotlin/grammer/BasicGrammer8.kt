package com.example.issuser.myapplication.kotlin.grammer

/**
 * @Author CelebrateG
 * @Description 字符与字符串模板
 * @Date  2018/11/7
 */
fun decimalDigitValue(c: Char): Int {
    if (c in '0'..'9') {
        return c.toInt()
    }
    throw IllegalArgumentException("Outer of range")
}

fun printDollar() {
    val price = """${'$'}9.99"""
    val price2 = "${'$'}9.99"
    val text = """
        for (c in "foo")
        print(c)
        \b,\n,\\ 与 \'$'
        |原始字符串 使用三个引号（""${'"'}）分界符括起来，
        |内部没有转义并且可以包含换行以及任何其他字符:
        |竖线用作边界，也可以用其他字符代替
"""
    println(price)
    println(price2)
    println(text.trimMargin())
}