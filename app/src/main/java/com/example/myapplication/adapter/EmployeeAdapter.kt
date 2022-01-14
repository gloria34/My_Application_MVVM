package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.Employee
import com.example.myapplication.databinding.EmployeeItemBinding

class EmployeeAdapter(private val employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.employee_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.binding.employee = employees[position]
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    class EmployeeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = EmployeeItemBinding.bind(itemView);
    }
}