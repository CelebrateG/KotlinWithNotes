package com.example.issuser.myapplication.kotlin.grammer

/**
 * @Author CelebrateG
 * @Description 循环控制语句：for,while与do...while
 * @Date  2018/10/18
 */

val LOLTeams = listOf<String>("LGD","EDG","KT","FNC")

/**
 * 不带下标的for循环
 */
fun useForExample1(){
    for (team in LOLTeams){
        print("$team ")
    }
    println("---------------")
}

/**
 * 带下标的for循环
 */
fun useForExample2(){
    for (i in LOLTeams.indices){
        print("$i,${LOLTeams[i]} ")
    }
    println("---------------")
}


fun useWhileExample(){
    var x = 3
    while (x > 0){
        print(x --)
    }
}

fun useDoWhileExample(){
    var y = 3
    do {
      print(-- y)
    } while (y > 3)
}


