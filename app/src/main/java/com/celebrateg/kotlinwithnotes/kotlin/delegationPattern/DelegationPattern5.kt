package com.example.issuser.myapplication.kotlin.delegationPattern

/**
 * @Author CelebrateG
 * @Description 对于类中数量任意的属性
 * 在 map 中保存属性值
 * 映射实例自身作为委托来实现委托属性
 * @Date  2018/10/26
 */

/**
 * 不使用委托时保存属性值
 */
class AJ11{
    private val _attributes = hashMapOf<String,String>()
    fun setAttributes(attrName:String,value:String){_attributes[attrName] = value }

    val name : String
    get() = _attributes["name"]!!
}

/**
 * 使用委托保存属性值
 */
class AJ33{
    private val _attributes = hashMapOf<String,String>()
    fun setAttributes(attrName:String,value:String){_attributes[attrName] = value }

    val name2 : String by _attributes
}

fun ajFunction(){
    val aj11 = AJ11()
    val aj33 = AJ33()
    val data =
            mapOf<String,String>("name" to "AirJordan11","color" to "black","name2" to "AirJordan33")
    for ((attrName,value) in data){
        aj11.setAttributes(attrName,value)
        aj33.setAttributes(attrName,value)
    }
    println(aj11.name)
    println(aj33.name2)
}

class Player(val map : Map<String,Any?>,val mmap:MutableMap<String,Any?>){
    val gender : Int by map
    // 这里var的属性使用MAP委托会报错：
    // Missing setValue(X,X,X)method on MAP
    // 因为Map中没有setValue方法
    var name:String by mmap
    var age : Int by mmap
}

fun checkPlayer(){
    val player = Player(mapOf(
            "gender" to "男"
    ), mutableMapOf(
            "name" to "Kyrie Irving",
            "age" to 27
    ))
    println(player.name)
    println(player.age)
    println(player.gender)
}


