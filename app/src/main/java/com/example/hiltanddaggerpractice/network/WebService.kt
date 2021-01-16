package com.example.hiltanddaggerpractice.network

import com.example.hiltanddaggerpractice.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("weather")
    fun getCityWeather(
        @Query("q") city: String,
        @Query("appid") appId: String
    ): Call<WeatherResponse>

}