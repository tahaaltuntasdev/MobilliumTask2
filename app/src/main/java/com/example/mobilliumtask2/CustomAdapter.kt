package com.example.mobilliumtask2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilliumtask2.databinding.RvItemBinding


class CustomAdapter(
    val cityDataList : ArrayList<CityData>,
    val listener : RecyclerViewEvent

):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : RvItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.rvItem.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.rvItemCityName.text = cityDataList.get(position).city
        viewHolder.binding.rvItemDegree.text = cityDataList.get(position).degree
        viewHolder.binding.rvItemWeather.text = cityDataList.get(position).weather
        viewHolder.binding.rvItemDegreeGap.text = cityDataList.get(position).degreeGap
    }

    override fun getItemCount(): Int {
        return cityDataList.size
    }

    interface RecyclerViewEvent{
        fun onItemClick(position: Int)
    }



}
