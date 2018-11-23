package com.example.issuser.myapplication.kotlin.classData

/**
 * @Author CelebrateG
 * @Description 密封类
 * 一个密封类是自身抽象的，它不能直接实例化并可以有抽象（abstract）成员。
 * 密封类构造函数不允许有非-private 构造函数（其构造函数默认为 private）。
 * @Date  2018/10/23
 */
//就算这里声明的是public，但在真正调用时仍然是private
public sealed class Expr constructor(var name:String) {

    private constructor() : this ("sealed class")

    /**
     * 定义继承了此类的数据类
     */
    data class Const(val number:Double) : Expr()

    data class Sum(val e1 : Expr,val e2 : Expr) : Expr()

    object NotNumber : Expr()


    /**
     * 语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句
     * 此函数判断expr的类型，根据类型选择分支执行，最终返回Double
     */
    fun eval(expr : Expr) : Double = when(expr){
        is Const -> expr.number
        is Sum -> eval(expr.e1) + eval(expr.e2)
        NotNumber -> Double.NaN
    }


}