package com.example.hiltanddaggerpractice.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltanddaggerpractice.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TestFragment())
//            .addToBackStack(TestFragment::class.java.canonicalName)
            .commitAllowingStateLoss()
    }

}