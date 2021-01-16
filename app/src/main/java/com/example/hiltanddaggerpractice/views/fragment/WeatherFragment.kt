package com.example.hiltanddaggerpractice.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.hiltanddaggerpractice.databinding.FragmentTestBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_test.*


@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private val mViewModel: WeatherViewModel by viewModels()


    private var fragmentBinding: FragmentTestBinding? = null

    //    lateinit var mViewModel: WeatherViewModel
    private val binding get() = fragmentBinding!!


//    @Inject
//    lateinit var testOne: TestOne

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentBinding = FragmentTestBinding.inflate(layoutInflater, container, false)
        val view = binding.root
//        return inflater.inflate(R.layout.fragment_test, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        testOne.helloTestOne()
//        testOne.helloTestTwo()

//         val mm=ViewModelProvider(this).get(WeatherViewModel::class.java)
        addSubscribers()
        buttonSearch.setOnClickListener {
            val city = edtEnterCity.text.toString()
            mViewModel.getWeather(city)

        }
    }


    fun addSubscribers() {
        mViewModel.mGetWeather.observe(this, Observer {

            it?.let {
                txtCityName.text = it.name
                it.main?.temp?.let {
                    val temp = it - 273.15
                    txtTemperature.text = temp.toInt().toString() + " \u2103"
                }

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }
}