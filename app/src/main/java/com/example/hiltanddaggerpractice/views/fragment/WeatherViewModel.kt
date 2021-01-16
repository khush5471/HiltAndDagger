package com.example.hiltanddaggerpractice.views.fragment

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.hiltanddaggerpractice.model.WeatherResponse


class WeatherViewModel @ViewModelInject constructor(
    private val repository: WeatherRepository,
    @Assisted savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    val mGetWeather = MutableLiveData<WeatherResponse>()


    fun getWeather(city: String) {
//        mGetWeather.value
        repository.getWeatherFromCity(city, {
            mGetWeather.value = it
        })
    }

}