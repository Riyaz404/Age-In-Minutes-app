package riyaz.project.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate:TextView?=null
    private var tvAgeInMintues:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btndatepicker:Button=findViewById(R.id.button)

        tvSelectedDate=findViewById(R.id.date)
        tvAgeInMintues=findViewById(R.id.min)

        btndatepicker.setOnClickListener {
            clickDatePicker()

        }
    }
    fun clickDatePicker(){
        val myCalendar = Calendar.getInstance()
        val year= myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog( this,
        DatePickerDialog.OnDateSetListener{ view,Selectedyear,Selectedmonth,SelecteddayOfMonth->
            Toast.makeText(this, "Developed by Riyaz Shaik",Toast.LENGTH_LONG).show()
            val selectedDate="$SelecteddayOfMonth/${Selectedmonth+1}/$Selectedyear"
            tvSelectedDate?.setText(selectedDate)

            var sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            var theDate=sdf.parse(selectedDate)

            val selectedDateInMinutes=theDate.time/60000

            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMinutes=currentDate.time/60000

            val differenceInMinutes =currentDateInMinutes - selectedDateInMinutes

            tvAgeInMintues?.text=differenceInMinutes.toString()

        },
                year,
                month,
                day
               ).show()



    }
}