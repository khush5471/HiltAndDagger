package com.example.hiltanddaggerpractice.views.fragment

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class TestModuleWithProvides {

//    @Singleton//this is optional
//    @Binds
//    abstract fun getInterFaceObject(testTwo: TestTwo):TestInterface// here getInterFaceObject take the object which has implemented interface

//    this code will give error
//    @Singleton//this is optional
//    @Binds
//    abstract fun getGson(testTwo: Gson):Gson


    @Singleton
    @Provides
    fun returnStringObject(): String {
        return "This string is from providers"
    }

    @Singleton
    @Provides
    fun getInterfaceObject(str: String): TestInterface {
        return TestTwo(str)//this is the class which have implemented TestInterface
    }

    @Singleton
    @Provides
    fun getGsonObject(): Gson {
        return Gson()
    }
}