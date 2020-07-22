package com.sns.notifyapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotifyReceiver : BroadcastReceiver() {
//Lifecycle
    val LIFECYCLE_RESUME_SATATE = "CREATED"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

    }
}
