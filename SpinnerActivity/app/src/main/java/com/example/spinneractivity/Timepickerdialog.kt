package com.example.spinneractivity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.*

class Timepickerdialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timepickerdialog)
        val btndate=findViewById<Button>(R.id.btdate)
        val textView=findViewById<TextView>(R.id.tv_date)
        val btntime=findViewById<Button>(R.id.bt_time)
        val textView1=findViewById<TextView>(R.id.tv_time)
        btndate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val monthName = arrayListOf(
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December")
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            Log.i("check", "$year $month $day")

            val datePickerDialog = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    textView.text = "$dayOfMonth / ${monthName[month]} / $year"

                },
                year, month, day
            )

            datePickerDialog.show()
        }
    btntime.setOnClickListener {

        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val min = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener {
                view, hourOfDay, minute ->
            val amPm: String = if (hourOfDay < 12) {
                "AM"
            } else {
                "PM"
            }
            Log.i("check", "$amPm $hourOfDay")
            /* if (hourOfDay == 0){
             binding.txtTime.text = "12 : $minute  $amPm"
             }
             else
             {
             }*/
            textView1.text = "$hourOfDay : $minute $amPm"
        },
            hour, min, false)
        timePickerDialog.show()

    }



    }
}