package com.example.issuser.myapplication.kotlin.classEnum

/**
 * @Author CelebrateG
 * @Description 声明自己的匿名类及相应的方法
 * 以及覆盖基类的方法
 * @Date  2018/10/24
 */

enum class P {
    WAITING {
        override fun s() = WAITING
    },
    TALKING {
        override fun s() = TALKING
    };

    //必须写在枚举成员后面
    abstract fun s(): P
}