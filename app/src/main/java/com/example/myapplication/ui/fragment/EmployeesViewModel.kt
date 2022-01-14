package com.example.myapplication.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.App.Companion.instance
import com.example.myapplication.R
import com.example.myapplication.data.model.EmployeeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class EmployeesViewModel : ViewModel() {
    val employees: MutableLiveData<EmployeeResponse> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()
    private val mainRepository = EmployeesRepository.instance

    fun loadEmployees() {
        mainRepository.getEmployees(object : Callback<EmployeeResponse> {
            override fun onResponse(
                call: Call<EmployeeResponse>,
                response: Response<EmployeeResponse>
            ) {
                employees.postValue(response.body())
            }

            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                t.printStackTrace()
                try {
                    val httpException = t as HttpException
                    error.postValue(
                        httpException.response()?.errorBody()?.string()
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                    error.postValue(instance!!.getString(R.string.unexpected_exception))
                }
            }
        })
    }
}