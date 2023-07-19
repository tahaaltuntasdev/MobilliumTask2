package com.example.mobilliumtask2.part3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobilliumtask2.R
import com.example.mobilliumtask2.databinding.FragmentDetailPage2Binding

class DetailPageFragment2 : Fragment() {

    private lateinit var binding : FragmentDetailPage2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPage2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*arguments.let {
            val data = it?.let {
                DetailPageFragment2Args.fromBundle(it).cityData
            }
            binding.weatherDegree.text = data?.degree
            binding.cityName.text = data?.city
        }*/

    }

}