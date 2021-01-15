package com.example.hiltanddaggerpractice.views.fragment

import javax.inject.Inject

class TestTwo @Inject constructor(val str: String) : TestInterface {

    fun helloTestTwo() {
        println("This is hello test two")
    }

    override fun thisIsInterfaceMethod(): String {
        return "This method is for interface " + str
    }
}