package com.sun.android.ex_slide14

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.sun.android.R
import com.sun.android.ex_slide14.BroadCastExActivity.Companion.ACTION_CUSTOM_BROADCAST

class CustomBroadcasts : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val intentAction = intent.action
        if (intentAction != null) {
            var toastMessage = R.string.unknown_intent_action
            when (intentAction) {
                Intent.ACTION_POWER_CONNECTED -> toastMessage = R.string.power_connect
                Intent.ACTION_POWER_DISCONNECTED -> toastMessage = R.string.power_disconnect
                ACTION_CUSTOM_BROADCAST -> toastMessage = R.string.custom_broadcast_received
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
