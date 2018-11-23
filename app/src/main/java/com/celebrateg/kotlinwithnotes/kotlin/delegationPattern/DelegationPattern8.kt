package com.example.issuser.myapplication.kotlin.delegationPattern

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

/**
 * @Author CelebrateG
 * @Description 框架中的委托属性
 * 使用委托属性访问数据库列
 * 这里使用了 GitHub 上 exposed 库
 * @Date  2018/11/22
 */

/**
 * Users 对象描述数据库的一个表，只需要一个实例
 * 属性分别表示数据表的列
 */
object Users : Table() {
    val name : Column<String> = varchar("name",length = 10).index()
    val age : Column<Int> = integer("age")
}

/**
 * Entity 包含了数据库列与值的映射
 * 每个实体属性使用列对象作为委托
 * 当调用 user.age += 1 数据库中相应实体将自动更新
 */
class User(id : EntityID<Int>) : Entity<Int>(id) {
    var name : String by Users.name
    var age : Int by Users.age
}

