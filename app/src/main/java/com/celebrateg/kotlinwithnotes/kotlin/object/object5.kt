package com.example.issuser.myapplication.kotlin.`object`

/**
 * @Author CelebrateG
 * @Description 伴生对象
 * 用 companion 关键字标记
 * @Date  2018/10/25
 */

class MyLOLTeam{
    /**
     * 每个类只允许声明一个伴生对象
     * 也可以省略伴生对象名称
     */
    companion object JSG{
        fun create():MyLOLTeam = MyLOLTeam()
        var name = "this is JiuShiGan Team"
        var members = arrayOf("Uzi","麻辣香锅","Faker","PDD","Miss")
        fun showMembers(){
            for (memberName in members){
                print("$memberName ")
            }
        }
    }
}

/**
 * 即使伴生对象的成员看起来像其他语言的静态成员
 * 在运行时他们仍然是真实对象的实例成员
 * 伴生对象的初始化是在相应的类被加载（解析）时，
 * 与 Java 静态初始化器的语义相匹配。
 */
fun jsgFunction(){
    println(MyLOLTeam.name)
    MyLOLTeam.showMembers()
}
