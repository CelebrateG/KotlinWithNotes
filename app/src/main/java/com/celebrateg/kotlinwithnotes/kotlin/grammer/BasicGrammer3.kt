package com.example.issuser.myapplication.kotlin.grammer

/**
 * @Author CelebrateG
 * @Description 计算字符串长度
 * is 类似于 instanceOf 关键字
 * @Date  2018/11/7
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}

fun getStringLength2(obj: Any): Int? {
    if (obj !is String) {
        return null
    }
    return obj.length
}

fun getStrngLength3(obj: Any): Int? {
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}
