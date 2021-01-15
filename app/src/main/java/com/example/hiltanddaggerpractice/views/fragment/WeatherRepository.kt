package com.example.hiltanddaggerpractice.views.fragment

import com.example.hiltanddaggerpractice.network.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val mService: WebService) {


    fun getWeatherFromCity(city: String) {
        mService.getCityWeather(city, "1de6a975068f98520e6710c07429c7bd")
            .enqueue(object : Callback<Objects> {
                override fun onFailure(call: Call<Objects>, t: Throwable) {

                }

                override fun onResponse(call: Call<Objects>, response: Response<Objects>) {
                }
            })

//        mService.getCityWeather(city,"")
    }
}
//1de6a975068f98520e6710c07429c7bd
