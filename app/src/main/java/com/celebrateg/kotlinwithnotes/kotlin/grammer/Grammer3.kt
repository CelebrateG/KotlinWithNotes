package com.example.issuser.myapplication.kotlin.grammer

/**
 * @Author CelebrateG
 * @Description break,continue和return
 * return：默认从最直接包围它的函数或者匿名函数返回。
 * break：终止最直接包围它的循环。
 * continue：继续下一次最直接包围它的循环。
 * @Date  2018/10/18
 */


/**
 * 跳过i==3的循环
 * 大于5时退出循环
 */
fun example1() {
    for (i in 1..10) {
        if (i == 3) continue
        if (i > 5) break
        print(i)
    }
    println("------------------")
}

/**
 * 使用return直接跳出该函数
 */
fun example2() {
    for (i in 1..3) {
        print("loop i: $i ")
        for (j in 4..10) {
            if (j == 5) return
            print("j : $j")
        }
        println("---------------")
    }
}


/**
 * 使用标签,当continue时，使外层循环本次循环
 * 当break时，使外层循环退出
 */
fun example3() {
    loop@ for (i in 1..5) {
        print("loop i: $i ")
        for (j in 4..10) {
            if (i == 4) break@loop
            if (j == 6) continue@loop
            print("j : $j")
        }
        println("---------------")
    }
}

/**
 * 不使用标签
 */
fun example4() {
    for (i in 1..5) {
        print("loop i: $i ")
        for (j in 4..10) {
            if (i == 4) break
            if (j == 6) continue
            print(",j : $j")
        }
        println("---------------")
    }
}

/**
 * 加标签并用以限制 return
 * 从lambda表达式中返回
 * forEach 对每个元素所要做的操作
 */
fun example5(){
    var ints = listOf<Int>(1,2,3,4,5)
    //不打印3
    ints.forEach() lint@{
        if (it == 3)return@lint
        print(it)
    }
    println("------------------")
}

/**
 * 使用隐式标签更方便。
 * 该标签与接受该 lambda 的函数同名
 */
fun example6(){
    var ints = listOf<Int>(1,2,3,4,5)
    ints.forEach(){
        if (it == 3)return@forEach
        print(it)
    }
    println("------------------")
}

/**
 * 使用匿名函数替代lambda表达式
 * 从匿名函数中return
 */
fun example7(){
    var ints = listOf<Int>(1,2,3,4,5)
    ints.forEach(fun(value : Int){
        if (value == 3)return
        print(value)
    })
    println("------------------")
}
