package com.sun.android.ex_slide14

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.sun.android.BuildConfig
import com.sun.android.R


class BroadCastExActivity : AppCompatActivity() {
    private val mReceiver: CustomBroadcasts = CustomBroadcasts()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast_ex)
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        this.registerReceiver(mReceiver, filter);
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mReceiver, IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    override fun onDestroy() {
        this.unregisterReceiver(mReceiver)
        super.onDestroy()
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(mReceiver);
    }

    fun sendCustomBroadcast(view: View) {
        val customBroadcastIntent = Intent(ACTION_CUSTOM_BROADCAST)
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }

    companion object {
        const val ACTION_CUSTOM_BROADCAST: String = BuildConfig.APPLICATION_ID + R.string.action_custom_broadcast
    }
}
