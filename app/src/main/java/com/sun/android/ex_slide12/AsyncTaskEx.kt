package com.sun.android.ex_slide12

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sun.android.R
import com.sun.android.databinding.ActivityAsyncTaskExBinding

class AsyncTaskEx : AppCompatActivity() {
    private val binding by lazy {
        ActivityAsyncTaskExBinding.inflate(layoutInflater)
    }
    private var textViewReadyToStart: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_ex)
        textViewReadyToStart = binding.textViewReadyToStart
        if (savedInstanceState != null) {
            textViewReadyToStart?.text = savedInstanceState.getString(TEXT_STATE)
        }
    }

    fun startTask(view: View?) {
        textViewReadyToStart?.setText(R.string.napping)
        var status: Int =0
        while (status<100){
            status+=1
            binding.progressBarAsync.progress
        }
        Toast.makeText(this, textViewReadyToStart?.text, Toast.LENGTH_LONG).show()
        SimpleAsyncTask(textViewReadyToStart).execute()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_STATE, textViewReadyToStart?.text.toString())
    }

    companion object {
        const val TEXT_STATE = "currentText"
    }

}
