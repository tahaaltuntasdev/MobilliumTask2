package com.example.mobilliumtask2.part2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilliumtask2.CityData
import com.example.mobilliumtask2.CustomAdapter
import com.example.mobilliumtask2.R
import com.example.mobilliumtask2.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment(R.layout.fragment_main_page), CustomAdapter.RecyclerViewEvent {

    private lateinit var binding: FragmentMainPageBinding
    private lateinit var cityDataList : ArrayList<CityData>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater)

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
        //Data binding with bundle
        val bundle = Bundle()
        bundle.putString("degreeData", cityDataList[position].degree)
        bundle.putString("cityName", cityDataList[position].city)
        val fragment = DetailPageFragment()
        fragment.arguments = bundle

        //For fragment transition
        parentFragmentManager.commit {
            replace(R.id.fragment, fragment)
            addToBackStack("DetailPageFragment")
        }
    }
}