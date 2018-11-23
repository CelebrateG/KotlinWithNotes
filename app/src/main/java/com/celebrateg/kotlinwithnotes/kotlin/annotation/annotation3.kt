package com.example.issuser.myapplication.kotlin.annotation

import kotlin.reflect.KClass

/**
 * @Author CelebrateG
 * @Description 声明注解
 * 对注解类的所有参数需强制使用 val
 * @Date  2018/11/16
 */

/**
 * 使用元注解 @Target() 指定目标：只在属性上标注
 * java 无法使用目标为 PROPERTY 的注解
 * FIELD 可以应用到 java 的字段上
 * 不使用 @Target 元注解
 */
@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude


@Target(AnnotationTarget.PROPERTY)
annotation class JsonName(val name:String)


/**
 * 声明类引用作为形参
 * out 关键字说明允许引用继承 Any 的类
 * 否则只能引用 Any::class 本身
 */
@Target(AnnotationTarget.PROPERTY)
annotation class DeserializeInterface(val targetClass: KClass<out Any>)