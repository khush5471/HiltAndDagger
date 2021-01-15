package com.example.hiltanddaggerpractice.views.fragment

import com.google.gson.Gson
import javax.inject.Inject

class TestOne @Inject constructor(private val testTwo: TestInterface, private val gson: Gson) {

    fun helloTestOne() {
        println("This is hello test on")
    }

    fun helloTestTwo() {
        println(testTwo.thisIsInterfaceMethod())
    }
}