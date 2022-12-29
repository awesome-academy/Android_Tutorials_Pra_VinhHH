package com.sun.android.ex_slide12

import android.os.AsyncTask
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import java.lang.ref.WeakReference
import java.util.*


class SimpleAsyncTask (tv: TextView?) : AsyncTask<Void?, Void?, String>() {
    private val textViewReadyToStart: WeakReference<TextView>
    init {
        textViewReadyToStart = WeakReference(tv)
    }
    override fun onPostExecute(result: String) {
        textViewReadyToStart.get()?.text = result
        Log.e("text1", textViewReadyToStart.get()?.text.toString())
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }
    override fun doInBackground(vararg p0: Void?): String {
        val r = Random()
        val n = r.nextInt(11)
        val s = n * 200
        try {
            Thread.sleep(s.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        Log.e("text", textViewReadyToStart.get()?.text.toString())
        return "Awake at last after sleeping for $s milliseconds!"
    }
}
