package com.example.issuser.myapplication.kotlin.annotation

/**
 * @Author CelebrateG
 * @Description 使用注解定制 Json 序列化
 * 使用 @JsonName 来改变在 Json 中用来表示它的键
 * 使用 @JsonExclude 在序列化和反序列化中排除
 * @Date  2018/11/16
 */
data class Car(var engine:String){
    /**
     * 可以省略掉实参的名称即 @JsonName("pinPai")
     * 但应用 java 声明的注解，需要对除 value 以外的
     * 所有实参使用命名实参语法
     */
    @JsonName(name = "pinPai")
    val brand : String = "BYD"

    @JsonExclude
    val chair : String? = null
}