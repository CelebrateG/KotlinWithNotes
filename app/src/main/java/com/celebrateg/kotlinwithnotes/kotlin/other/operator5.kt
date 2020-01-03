package com.example.issuser.myapplication.kotlin.other

/**
 * @Author CelebrateG
 * @Description 排序运算符 CompareTo
 * @Date  2018/11/13
 */
class Player(val firstName:String ,val lastName:String):Comparable<Player>{
    override fun compareTo(other: Player): Int {
        return compareValuesBy(this,other,Player::firstName,Player::lastName)
    }

    override fun toString(): String {
        return "Player(firstName='$firstName', lastName='$lastName')"
    }

}

fun compare(){
    var player1 = Player("Kobe","Bryant")
    var player2 = Player("Joe","Bryant")
//  相当于 player1.compareTo(player2) > 0)
    println(player1 > player2)
}