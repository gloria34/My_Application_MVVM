package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.adapter.EmployeeAdapter
import com.example.myapplication.databinding.FragmentEmployeesBinding

class EmployeesFragment : Fragment(R.layout.fragment_employees) {
    private lateinit var employeesViewModel: EmployeesViewModel
    private lateinit var binding: FragmentEmployeesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadEmployees()
    }

    private fun loadEmployees() {
        employeesViewModel = ViewModelProvider(this)[EmployeesViewModel::class.java]
        employeesViewModel.employees.observe(requireActivity(), {
            val employeeAdapter = EmployeeAdapter(it.response)
            binding.employeesRecyclerView.adapter = employeeAdapter
        })
        employeesViewModel.error.observe(requireActivity(), {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
        employeesViewModel.loadEmployees()
    }
}