package com.example.hiltanddaggerpractice.views.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltanddaggerpractice.R
import com.example.hiltanddaggerpractice.views.fragment.WeatherFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //    private val viewModel:WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        viewModel.getWeather("montreal")
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                WeatherFragment()
            )
//            .addToBackStack(TestFragment::class.java.canonicalName)
            .commitAllowingStateLoss()
    }

}