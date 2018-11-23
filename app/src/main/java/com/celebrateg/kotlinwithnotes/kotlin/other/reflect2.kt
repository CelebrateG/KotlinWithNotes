package com.example.issuser.myapplication.kotlin.other

import com.example.issuser.myapplication.kotlin.annotation.CustomSerializer
import com.example.issuser.myapplication.kotlin.annotation.JsonExclude
import com.example.issuser.myapplication.kotlin.annotation.JsonName
import com.example.issuser.myapplication.kotlin.annotation.ValueSerializer
import ru.yole.jkid.*
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
/**
 * @Author CelebrateG
 * @Description 用反射实现对象序列化，用注解定制序列化
 * @Date  2018/11/19
 */

//定义全局序列化函数
fun serialize(obj: Any): String = buildString { serializeObject(obj) }


/**
 * 沒有注解的序列化
 * 保证属性与属性之间用逗号隔开
 */
private fun StringBuilder.serializeObjectWithoutAnnotation(obj: Any) {
    val kClass = obj.javaClass.kotlin
    val properties = kClass.memberProperties

    properties.joinToStringBuilder(this, prefix = "{", postfix = "}") { prop ->
        serializeString(prop.name)
        append(": ")
        serializePropertyValue(prop.get(obj))
    }
}

/**
 * 过滤 @JsonExclude 注解的属性
 * findAnnotation 返回该注解的实例
 * 在 filter 中判断该实例是否为 null
 * false 则过滤掉
 */
private fun StringBuilder.serializeObject(obj: Any) {
    obj.javaClass.kotlin.memberProperties
            .filter { it.findAnnotation<JsonExclude>() == null }
            .joinToStringBuilder(this, prefix = "{", postfix = "}") {
                serializeProperty(it, obj)
            }
}
/**
 * 如果属性没有标注 @JsonName 注解，使用属性字段名称
 * 否则使用注解中指定的名称
 */
private fun StringBuilder.serializeProperty(
        prop: KProperty1<Any, *>, obj: Any
) {
    val jsonNameAnn = prop.findAnnotation<JsonName>()
    val propName = jsonNameAnn?.name ?: prop.name
    serializeString(propName)
    append(": ")

    /**
     * 如果自定义序列化器不存在，则使用 原值
     * 否则使用 toJsonValue 方法
     */
    val value = prop.get(obj)
    val jsonValue = prop.getSerializer()?.toJsonValue(value) ?: value
    serializePropertyValue(jsonValue)
}

/**
 * 通过属性的扩展函数
 * 实现 @CustomSerializer 自定义序列化注解
 * 返回属性序列化器的实例
 */
fun KProperty<*>.getSerializer(): ValueSerializer<Any?>? {
    val customSerializerAnn = findAnnotation<CustomSerializer>() ?: return null
    val serializerClass = customSerializerAnn.serializerClass

    /**
     * serializerClass 注解实例的属性值：对象或普通的类
     * 对象拥有非空值 objectInstance 属性，可以用于访问其单例实例
     * 普通类可以通过 createInstance 来创建新的实例
     */
    val valueSerializer = serializerClass.objectInstance
            ?: serializerClass.createInstance()
    //抑制警告
    @Suppress("UNCHECKED_CAST")
    return valueSerializer as ValueSerializer<Any?>
}

private fun StringBuilder.serializePropertyValue(value: Any?) {
    when (value) {
        null -> append("null")
        is String -> serializeString(value)
        is Number, is Boolean -> append(value.toString())
        is List<*> -> serializeList(value)
        else -> serializeObject(value)
    }
}

private fun StringBuilder.serializeList(data: List<Any?>) {
    data.joinToStringBuilder(this, prefix = "[", postfix = "]") {
        serializePropertyValue(it)
    }
}

private fun StringBuilder.serializeString(s: String) {
    append('\"')
    s.forEach { append(it.escape()) }
    append('\"')
}

private fun Char.escape(): Any =
        when (this) {
            '\\' -> "\\\\"
            '\"' -> "\\\""
            '\b' -> "\\b"
            '\u000C' -> "\\f"
            '\n' -> "\\n"
            '\r' -> "\\r"
            '\t' -> "\\t"
            else -> this
        }
