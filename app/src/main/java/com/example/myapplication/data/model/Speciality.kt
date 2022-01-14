package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Speciality(
    @SerializedName("specialty_id")
    var specialtyId: Int = 0,
    var name: String = ""
)
