package com.example.mobilliumtask2.part2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobilliumtask2.databinding.FragmentDetailPageBinding


class DetailPageFragment : Fragment() {

    private lateinit var binding : FragmentDetailPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPageBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            val data1 = it?.getString("degreeData")
            val data2 = it?.getString("cityName")

            binding.weatherDegree.text = data1
            binding.cityName.text = data2

        }
    }


}