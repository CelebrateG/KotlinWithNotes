package com.example.issuser.myapplication.kotlin.delegationPattern
/**
 * @Author CelebrateG
 * @Description 惰性初始化
 * @Date  2018/10/26
 */
class Email
/**
 * 使用支持属性来实现惰性初始化
 * 只有在首次访问时才加载邮件，并只执行一次
 * 这种实现不是线程安全的
 */
fun loadEmail(company: Company):List<Email>{
    println("load Emails for ${company.name}")
    return listOf()
}
class Company(val name:String){
    private var _emails:List<Email>? = null
    val email:List<Email>
        get(){
            if (_emails == null){
                _emails = loadEmail(this)
            }
            return _emails!!
        }
}
fun lazyFun1(){
    val company = Company("Nike")
    company.email
    company.email
}


/**
 * 使用委托属性来实现惰性初始化
 */
fun loadEmail2(company: Company2):List<Email>{
    println("load Emails for ${company.name}")
    return listOf()
}
class Company2(val name:String){
    val email by lazy{ loadEmail2(this)}
}
fun lazyFun2(){
    val company = Company2("Adidas")
    company.email
    company.email
}


/**
 * 返回一个 Lazy <T> 实例的函数
 * 返回的实例即延迟属性值
 * 延迟属性 Lazy,只能用在 val 类型
 * 默认情况下，对于 lazy 函数是线程安全的:即求值是同步锁的（synchronized），
 * 只在一个线程中计算，并且所有线程会看到相同的值。
 * 如果希望初始化委托不需要同步锁，多个线程会同时执行，
 * 那么将 LazyThreadSafetyMode.PUBLICATION 作为参数传递给 lazy() 函数。
 * 而如果你确定初始化将总是发生在单个线程，那么你可以使用 LazyThreadSafetyMode.NONE 模式，
 * 它不会有任何线程安全的保证以及相关的开销。
 */
val lazyValue : String by lazy(LazyThreadSafetyMode.NONE) {
    println("computed!")
    "Hello"
}

/**
 * 第一次调用 get()，会执行 lambda 表达式，并记录结果
 * 后续调用 get() 只是返回记录的结果
 */
fun main(args: Array<String>) {
    lazyFun1()
    lazyFun2()
    println(lazyValue)
    println(lazyValue)
}

