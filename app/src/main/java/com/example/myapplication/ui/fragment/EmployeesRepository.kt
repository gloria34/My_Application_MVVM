package com.example.myapplication.ui.fragment
import com.example.myapplication.data.api.ApiFactory
import com.example.myapplication.data.model.EmployeeResponse
import retrofit2.Callback


class EmployeesRepository {
    private val apiService = ApiFactory.instance?.apiService

    fun getEmployees(callbackListener: Callback<EmployeeResponse>) {
        apiService?.getEmployees()?.enqueue(callbackListener)
    }

    companion object {
        val instance = EmployeesRepository()
    }
}