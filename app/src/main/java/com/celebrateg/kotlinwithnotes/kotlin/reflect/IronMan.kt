package com.celebrateg.kotlinwithnotes.kotlin.reflect

class IronMan constructor() {
    var param: Double? = null
    var fieldName: String? = null

    constructor(param: Double, fieldName: String) : this() {
        this.param = param
        this.fieldName = fieldName
    }

    override fun toString(): String {
        return "IronMan(param=$param, fieldName=$fieldName)"
    }

}