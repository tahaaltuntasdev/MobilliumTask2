package com.example.mobilliumtask2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityData  (
    val city : String,
    var degree : String,
    val degreeGap : String,
    val weather : String
) : Parcelable
