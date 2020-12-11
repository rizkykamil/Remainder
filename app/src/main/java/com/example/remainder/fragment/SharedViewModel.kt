package com.example.remainder.fragment

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.remainder.R
import com.example.remainder.data.Priority
import com.example.remainder.data.ToDoData

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkIfDatabaseEmpty(toDoData: List<ToDoData>){
        emptyDatabase.value = toDoData.isEmpty()
    }

    val listener: AdapterView.OnItemSelectedListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(parents: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(position){
                0-> {
                    (parents?.getChildAt(0)as TextView)
                        .setTextColor(
                            ContextCompat
                                .getColor(application, R.color.red)
                        )
                }
                1 -> {
                    (parents?.getChildAt(0)as TextView)
                        .setTextColor(
                            ContextCompat
                                .getColor(application, R.color.yellow)
                        )
                }
                2 -> {
                    (parents?.getChildAt(0)as TextView)
                        .setTextColor(
                            ContextCompat
                                .getColor(application, R.color.green)
                        )
                }
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {}

    }

     fun parsePriority(priority: String): Priority {
        return when(priority){
            "High Priority" -> {
                Priority.HIGH
            }
            "Medium Priority" -> {
                Priority.MEDIUM
            }

            "Low Priority" ->{
                Priority.LOW
            }
            else -> Priority.LOW
        }
    }

    fun verifyDataFormat(title: String, description: String): Boolean {
        return !(title.isEmpty() || description.isEmpty())

    }
}