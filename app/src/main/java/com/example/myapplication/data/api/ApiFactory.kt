package com.example.myapplication.data.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory private constructor() {
    val apiService: ApiService
        get() = retrofit.create(ApiService::class.java)

    init {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    companion object {
        private var apiFactory: ApiFactory? = null
        private lateinit var retrofit: Retrofit
        private const val BASE_URL = "http://gitlab.65apps.com/65gb/static/raw/master/"
        val instance: ApiFactory?
            get() {
                if (apiFactory == null) {
                    apiFactory = ApiFactory()
                }
                return apiFactory
            }
    }
}