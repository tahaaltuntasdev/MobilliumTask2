package com.example.mobilliumtask2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilliumtask2.databinding.RvItemBinding
import com.example.mobilliumtask2.part2.MainActivity2


class CustomAdapter(
    private val cityDataList: ArrayList<CityData>,
    val listener: RecyclerViewEvent

):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : RvItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.rvItem.setOnClickListener{
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.rvItemCityName.text = cityDataList[position].city
        viewHolder.binding.rvItemDegree.text = cityDataList[position].degree
        viewHolder.binding.rvItemWeather.text = cityDataList[position].weather
        viewHolder.binding.rvItemDegreeGap.text = cityDataList[position].degreeGap
    }

    override fun getItemCount(): Int {
        return cityDataList.size
    }

    interface RecyclerViewEvent{
        fun onItemClick(position: Int)

    }

}
