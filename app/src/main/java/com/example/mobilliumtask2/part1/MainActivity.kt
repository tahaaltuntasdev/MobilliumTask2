package com.example.mobilliumtask2.part1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilliumtask2.CityData
import com.example.mobilliumtask2.CustomAdapter
import com.example.mobilliumtask2.databinding.ActivityMainBinding
import com.example.mobilliumtask2.databinding.RvItemBinding


class MainActivity : AppCompatActivity(),
CustomAdapter.RecyclerViewEvent
{
    private lateinit var cityDataList : ArrayList<CityData>
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        cityDataList = ArrayList<CityData>()

        val istanbul = CityData("İstanbul", "26°", "14° - 27°", "Güneşli")
        val ankara = CityData("Ankara", "25°", "14° - 27°", "Güneşli")
        val erzurum = CityData("Erzurum", "24°", "14° - 27°", "Güneşli")
        val sakarya = CityData("Sakarya", "26°", "14° - 27°", "Güneşli")

        cityDataList.add(istanbul)
        cityDataList.add(ankara)
        cityDataList.add(erzurum)
        cityDataList.add(sakarya)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val customAdapter = CustomAdapter(cityDataList , this)
        binding.recyclerView.adapter = customAdapter


    }

    override fun onItemClick(position: Int) {
        val action = cityDataList[position]
        val intent = Intent(this, DetailMainActivity::class.java)
        val city = action.city
        val degree = action.degree

        intent.putExtra("city",city)
        intent.putExtra("degree",degree)

        startActivity(intent)
    }


    }
