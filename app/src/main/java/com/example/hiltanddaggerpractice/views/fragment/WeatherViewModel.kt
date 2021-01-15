package com.example.hiltanddaggerpractice.views.fragment

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.util.*


class WeatherViewModel @ViewModelInject constructor(
    private val repository: WeatherRepository,
    @Assisted savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    val mGetWeather = MutableLiveData<Objects>()


    fun getWeather(city: String) {
//        mGetWeather.value
        repository.getWeatherFromCity(city)
    }

}