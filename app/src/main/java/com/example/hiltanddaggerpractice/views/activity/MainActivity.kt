package com.example.hiltanddaggerpractice.views.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltanddaggerpractice.databinding.ActivityMainBinding
import com.example.hiltanddaggerpractice.views.fragment.WeatherFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportFragmentManager.beginTransaction()
            .replace(
                binding.container.id,
                WeatherFragment()
            )
            .commitAllowingStateLoss()
    }

}