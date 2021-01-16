package com.example.hiltanddaggerpractice.views.fragment

import com.example.hiltanddaggerpractice.model.WeatherResponse
import com.example.hiltanddaggerpractice.network.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val mService: WebService) {


    fun getWeatherFromCity(city: String, wheatherResponse: (WeatherResponse) -> Unit) {
        mService.getCityWeather(city, "1de6a975068f98520e6710c07429c7bd")
            .enqueue(object : Callback<WeatherResponse> {
                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    response.body()?.let {
                        wheatherResponse(it)
                    }
                }
            })

//        mService.getCityWeather(city,"")
    }
}
//1de6a975068f98520e6710c07429c7bd
