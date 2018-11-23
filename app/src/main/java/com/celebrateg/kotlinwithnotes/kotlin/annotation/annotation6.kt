package com.example.issuser.myapplication.kotlin.annotation
import com.example.issuser.myapplication.kotlin.other.serialize
import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.KClass

/**
 * @Author CelebrateG
 * @Description 使用泛型类做注解参数
 * @Date  2018/11/19
 */
//作为一个序列化器
interface ValueSerializer<T> {
    fun toJsonValue(value: T): Any?
    fun fromJsonValue(jsonValue: Any?): T
}

/**
 * 定义继承 ValueSerializer 序列化器接口的参数
 * 允许序列化器序列化任何值
 */
@Target(AnnotationTarget.PROPERTY)
annotation class CustomSerializer(val serializerClass: KClass<out ValueSerializer<*>>)

//实现对象
object DateSerializer : ValueSerializer<Date> {
    private val dateFormat = SimpleDateFormat("dd-mm-yyyy")

    override fun toJsonValue(value: Date): Any? =
            dateFormat.format(value)

    override fun fromJsonValue(jsonValue: Any?): Date =
            dateFormat.parse(jsonValue as String)
}

//使用
data class Pen(
        val name: String,
        //对象作为实参
        @CustomSerializer(DateSerializer::class)
        val produceDate: Date
)

fun testJsonSerializer(){
    var p = Pen("Alice", SimpleDateFormat("dd-mm-yyyy").parse("13-02-1987"))
    println(serialize(p))
    val json = """{"birth   Date": "13-02-1987", "name": "Alice"}"""
    println(json)
}