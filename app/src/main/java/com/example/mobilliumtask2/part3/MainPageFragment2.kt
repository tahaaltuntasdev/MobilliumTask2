package com.example.mobilliumtask2.part3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilliumtask2.CityData
import com.example.mobilliumtask2.CustomAdapter
import com.example.mobilliumtask2.R
import com.example.mobilliumtask2.databinding.FragmentMainPage2Binding

class MainPageFragment2 : Fragment(R.layout.fragment_main_page2), CustomAdapter.RecyclerViewEvent {

    private lateinit var binding : FragmentMainPage2Binding
    private lateinit var cityDataList : ArrayList<CityData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPage2Binding.inflate(inflater)
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
        val customAdapter = CustomAdapter(cityDataList, this )
        binding.recyclerView.adapter = customAdapter

    }

    override fun onItemClick(position: Int) {
        /*  findNavController().navigate(MainPageFragment2Directions.actionMainPageFragment2ToDetailPageFragment2(
              cityDataList[position]))
  */
      }

}