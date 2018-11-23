package com.example.issuser.myapplication.kotlin.annotation

/**
 * @Author CelebrateG
 * @Description 使用类做注解参数
 * @Date  2018/11/19
 */

interface Company{
    val name:String
}

data class CompanyImpl(override val name: String) : Company

data class Product(val name:String){
    @DeserializeInterface(CompanyImpl::class)
    val company : Company = CompanyImpl("NASA")
}
