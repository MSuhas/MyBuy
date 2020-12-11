package com.first.mybuy.test

data class Book @JvmOverloads constructor(var name: String, var price: Int=100) {

    @JvmOverloads
    fun testFun(a:Int, b:String="") {

    }
}