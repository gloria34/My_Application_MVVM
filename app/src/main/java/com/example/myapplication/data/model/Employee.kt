package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("f_name")
    var name: String = "",

    @SerializedName("l_name")
    var lName: String = "",

    var birthday: String = "",

    @SerializedName("avatr_url")
    var avatarUrl: String = "",

    @SerializedName("specialty")
    var specialties: List<Speciality>? = ArrayList()
)
