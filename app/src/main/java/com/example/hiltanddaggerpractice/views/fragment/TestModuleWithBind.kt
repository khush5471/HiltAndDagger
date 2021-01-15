//package com.example.hiltanddaggerpractice.views.fragment
//
//import com.google.gson.Gson
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
//import javax.inject.Singleton
//
//@InstallIn(ApplicationComponent::class)
//@Module
//abstract class TestModuleWithBind {
//
//    @Singleton//this is optional
//    @Binds
//    abstract fun getInterFaceObject(testTwo: TestTwo):TestInterface// here getInterFaceObject take the object which has implemented interface
//
////    this code will give error
////    @Singleton//this is optional
////    @Binds
////    abstract fun getGson(testTwo: Gson):Gson
//
//}