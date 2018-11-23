package com.example.issuser.myapplication.kotlin.classNested

/**
 * @Author CelebrateG
 * @Description 包含接口参数的方法，用于测试匿名内部类
 * @Date  2018/10/19
 */
class Outer3 {
    /**
     * 调用此方法时，需要实现此接口
     */
    fun setInterface(anInt : AnInterface){
        anInt.aMethod()
    }
}

/**
 * 用于测试匿名内部类的接口
 */
interface AnInterface {
    fun aMethod()
}