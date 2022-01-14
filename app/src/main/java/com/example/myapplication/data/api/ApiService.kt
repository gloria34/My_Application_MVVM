package com.example.myapplication.data.api

import com.example.myapplication.data.model.EmployeeResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("testTask.json")
    fun getEmployees(): Call<EmployeeResponse>?
}