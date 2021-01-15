package com.example.hiltanddaggerpractice.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
//import androidx.fragment.app.viewModels
import com.example.hiltanddaggerpractice.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private val mViewModel: WeatherViewModel by viewModels()


    @Inject
    lateinit var testOne: TestOne

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testOne.helloTestOne()
        testOne.helloTestTwo()

        mViewModel.getWeather("montreal")
    }

}