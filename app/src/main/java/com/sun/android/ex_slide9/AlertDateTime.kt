package com.sun.android.ex_slide9

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.sun.android.R
import com.sun.android.databinding.ActivityAlertDateTimeBinding

class AlertDateTime : AppCompatActivity() {
    private val binding by lazy {
        ActivityAlertDateTimeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_date_time)
    }

    fun onClickShowAlert(view: View?) {
        val exAlertBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        exAlertBuilder.setTitle(R.string.alert)
        exAlertBuilder.setMessage(R.string.alert_click_message)
        exAlertBuilder.setPositiveButton(R.string.ok_message) { _, _ ->
            Toast.makeText(applicationContext, R.string.press_ok, Toast.LENGTH_LONG).show()
        }
        exAlertBuilder.setNegativeButton(R.string.cancel_message) { _, _ ->
            Toast.makeText(applicationContext, R.string.press_cancel, Toast.LENGTH_LONG).show()
        }
        exAlertBuilder.show();
    }

    fun showDatePicker(view: View?) {
        val newFragment: DialogFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        val month = (month + 1).toString()
        val day = day.toString()
        val year = year.toString()
        val dateMessage = "$day/$month/$year"
        Toast.makeText(this, "$dateMessage", Toast.LENGTH_SHORT).show();
    }
}
