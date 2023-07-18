package com.example.mobilliumtask2.part1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilliumtask2.databinding.ActivityDetailMainBinding


class DetailMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
        val cityData = intent.getStringExtra("city")
        binding.cityName.text = cityData

        val degreeData = intent.getStringExtra("degree")
        binding.weatherDegree.text = degreeData


*/
    }

}