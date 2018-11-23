package com.example.issuser.myapplication.kotlin.classAttr

/**
 * @Author CelebrateG
 * @Description Team实体类
 * @Date  2018/10/18
 */
class Team {
    /**
     * 延迟初始化属性与变量(var)
     * 仅当该属性没有自定义 getter 或 setter
     * 属性或变量必须为非空类型和非基本类型
     * 否则编译会报错
     */
    lateinit var person: Person

    lateinit var teamName: String


    /**
     * 检测一个 lateinit var 是否已初始化
     * 此检测仅对可词法级访问的属性可用
     * 即声明位于同一个类型内、位于其中一个外围类型中(外部类)或者位于相同文件的顶层的属性。
     */
    fun testA() {
        //::表示引用其他函数作为此函数的参数
        if (Team::person.isLateinit) {
            println("person is not init")
        } else {
            println("person has init")
        }
    }

}