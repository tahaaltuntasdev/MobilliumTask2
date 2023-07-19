package com.example.mobilliumtask2.part4

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilliumtask2.CityData
import com.example.mobilliumtask2.CustomAdapter
import com.example.mobilliumtask2.R
import com.example.mobilliumtask2.databinding.FragmentMainPage3Binding

class MainPageFragment3 : Fragment(R.layout.fragment_main_page3), CustomAdapter.RecyclerViewEvent {

    private lateinit var binding: FragmentMainPage3Binding
    private lateinit var cityDataList: ArrayList<CityData>
    private var cityData: CityData? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPage3Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityDataList = ArrayList<CityData>()
        val istanbul = CityData("İstanbul", "26°", "14° - 27°", "Güneşli")
        val ankara = CityData("Ankara", "25°", "14° - 27°", "Güneşli")
        val erzurum = CityData("Erzurum", "24°", "14° - 27°", "Güneşli")
        val sakarya = CityData("Sakarya", "26°", "14° - 27°", "Güneşli")

        cityDataList.add(istanbul)
        cityDataList.add(ankara)
        cityDataList.add(erzurum)
        cityDataList.add(sakarya)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val customAdapter = CustomAdapter(cityDataList, this)
        binding.recyclerView.adapter = customAdapter


        parentFragmentManager.setFragmentResultListener(
            "detailPageData",
            this,
            FragmentResultListener { requestKey, result ->
                cityData = if (Build.VERSION.SDK_INT >= 33) {
                    result.getParcelable("cityData", CityData::class.java)
                } else {
                    result.getParcelable("cityData")
                }

                if(cityData != null) {
                    var cityDataIndex : Int ?= null
                    cityDataList.forEachIndexed { index, data ->
                        if(data.city == cityData?.city) {
                            cityDataIndex = index
                        }
                    }
                    cityDataIndex?.let {
                        cityDataList.set(cityDataIndex!!, cityData!!)
                    }
                }

            })




    }

    override fun onItemClick(position: Int) {
        findNavController().navigate(
            MainPageFragment3Directions.actionMainPageFragment3ToDetailPageFragment3(
                cityDataList[position]
            )
        )
    }


}