package com.example.issuser.myapplication.kotlin.delegationPattern

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * @Author CelebrateG
 * @Description 当一个对象的属性更改时通知监听器
 * 可观察属性 Observable
 * @Date  2018/10/26
 */

/**
 * 1、不使用委托属性方式实现，使用 java 属性通知的机制：
 * PropertyChangeSupport 和 PropertyChangeEvent
 * 用法通常是将 PropertyChangeSupport 的实例存储为 bean 类的一个字段，
 * 当 bean 属性更改时委托给它。
 * 此处先封装一个工具类，让 bean 类继承
 */
open class PropertyChangeAware{
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener:PropertyChangeListener){
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener:PropertyChangeListener){
        changeSupport.removePropertyChangeListener(listener)
    }
}
class Shoes(val name: String,size:Int,price:Int): PropertyChangeAware() {
    var size:Int = size
    set(newValue){
        val oldValue = field
        field = newValue
        //当属性变化时，通知监听器
        changeSupport.firePropertyChange("size",oldValue,newValue)
    }
    var price:Int = price
    set(newValue){
        val oldValue = field
        field = newValue
        changeSupport.firePropertyChange("price",oldValue,newValue)
    }
}
fun attrChangeFunction1(){
    val shoes = Shoes("AJ11",44,1400)
    //实现并添加一个属性改变监听器
    shoes.addPropertyChangeListener(PropertyChangeListener{evt ->
        println("${shoes.name}:${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}") })

    shoes.price = 1100
    shoes.size = 43
}


/**
 * 2、通过辅助类实现属性变化通知
 */
class ObservableProperty(val propName :String, var propValue:Int,
                         val changeSupport: PropertyChangeSupport){
    fun getValue():Int = propValue
    fun setValue(newValue: Int){
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName,oldValue,newValue)
    }
}
class Slipper(val name: String,size:Int,price:Int): PropertyChangeAware() {
    val _size = ObservableProperty("size",size,changeSupport)
    var size :Int
        get() = _size.getValue()
        set(value) = _size.setValue(value)
    val _price = ObservableProperty("price",price,changeSupport)
    var price :Int
        get() = _price.getValue()
        set(value) = _price.setValue(value)
}
fun attrChangeFunction2(){
    val slipper = Slipper("人字拖",44,100)
    //实现并添加一个属性改变监听器
    slipper.addPropertyChangeListener(PropertyChangeListener{evt ->
        println("${slipper.name}:${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}") })

    slipper.price = 50
    slipper.size = 43
}


/**
 * 3、通过委托属性实现更改通知
 * 受委托类需实现 operator 关键字标记的 getValue、 setValue 方法
 * 其中第1个参数：用于接受属性的实例，第二个参数：属性本身
 * 可以通过 prop.name 访问属性名称
 */
class ObservableProperty2(var propValue:Int,
                          val changeSupport: PropertyChangeSupport){
    operator fun getValue(shoes: Shoes2,prop:KProperty<*>):Int = propValue
    operator fun setValue(shoes: Shoes2,prop:KProperty<*>,newValue: Int){
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name,oldValue,newValue)
    }
}
class Shoes2(val name: String,size:Int,price:Int): PropertyChangeAware() {
    var size:Int by ObservableProperty2(size,changeSupport)
    var price:Int by ObservableProperty2(price,changeSupport)
}
fun attrChangeFunction3(){
    val shoes = Shoes2("LBJ16",44,1600)
    //实现并添加一个属性改变监听器
    shoes.addPropertyChangeListener(PropertyChangeListener{evt ->
        println("${shoes.name}:${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}") })

    shoes.price = 1100
    shoes.size = 43
}


/**
 * 4、使用标准库 Delegates.observable 实现属性修改的通知
 * 标准库包含了类似于 ObservableProperty2 的类
 */
class Boots(val name: String,size:Int,price:Int){
    private val observable = {
        prop:KProperty<*>,oldValue:Int,newValue:Int ->
        println("${prop.name} changed from $oldValue to $newValue")
    }
    var size :Int by Delegates.observable(size,observable)
    var price :Int by Delegates.observable(price,observable)
}
fun attrChangeFunction4(){
    val shoes = Boots("airForce",44,1200)
    shoes.price = 1000
}


fun myObservable() {
    /**
     * Delegates.observable() 接受两个参数：
     * 初始值与修改时的处理程序（handler）
     */
    var name: String by Delegates.observable("<no name>") {
        /**
         * lambda表达式 handler 函数中有三个参数：
         * 被赋值的属性、旧值与新值
         */
        property, oldValue, newValue ->

        println("$oldValue -> $newValue")
    }
    name = "first"
    name = "second"
}

/**
 * Delegates.vetoable 允许回调否决修改
 * 在属性被赋新值生效之前会调用传递给 vetoable 的处理程序
 * 如果字符串包含 i 则会被赋值
 */
fun myVetoable(){
    var name: String by Delegates.vetoable("init"){
        property, oldValue, newValue ->
        newValue.contains("i")
    }
    name = "first"
    print("$name ->")
    name = "second"
    print("$name ->")
    name = "third"
    println(name)
}