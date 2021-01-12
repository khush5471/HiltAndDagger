package com.example.hiltanddaggerpractice.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface WebService {

    @GET("weather")
    fun getCityWeather(@Query("q") city: String, @Query("appid") appId: String): Call<Objects>

}