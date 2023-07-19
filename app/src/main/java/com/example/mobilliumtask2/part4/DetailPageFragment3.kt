package com.example.mobilliumtask2.part4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobilliumtask2.CityData
import com.example.mobilliumtask2.R
import com.example.mobilliumtask2.databinding.FragmentDetailPage3Binding


class DetailPageFragment3 : Fragment() {

    private lateinit var binding : FragmentDetailPage3Binding
    private var cityData : CityData ?= null
    private var randomDegree : Int ?= null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPage3Binding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            cityData = it?.let {
                DetailPageFragment3Args.fromBundle(it).cityData
            }
            binding.weatherDegree.text = cityData?.degree
            binding.cityName.text = cityData?.city
        }

        binding.weatherImg.setOnClickListener {
            dataRefresh()
        }

        binding.btnUpdate.setOnClickListener {
            sendData()
        }

    }

    private fun dataRefresh(){
        val degree = cityData?.degreeGap?.split("° - ")
        val minDegree = degree?.first()?.toInt()
        val maxDegree = degree?.last()?.split("°")?.first()?.toInt()

        if (minDegree != null && maxDegree != null) {
            randomDegree = minDegree.rangeTo(maxDegree).random()
            binding.weatherDegree.text = randomDegree.toString()+"°"
        }
    }

    private fun sendData(){
        if (randomDegree != null){
            cityData?.degree = randomDegree.toString()+"°"

            val bundle = Bundle()
            bundle.putParcelable("cityData", cityData)
            parentFragmentManager.setFragmentResult("detailPageData", bundle)
        }
    }



}