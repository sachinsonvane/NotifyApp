package com.sns.notifyapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.util.*

class NotifyReceiver : BroadcastReceiver() {

    val LIFECYCLE_CREATED_SATATE:String = "CREATED"
    lateinit var mContext: Context

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        mContext = context.applicationContext
        System.out.println("## onReceive ")
        var wasBackground = MyApplication.mInstance!!.isBackground()
        System.out.println("## mWasInBackground " + wasBackground)
        if (wasBackground==LIFECYCLE_CREATED_SATATE) {
            createNotificationChannel()
        }
    }

    private fun createNotificationChannel() {

        // Create and register notification channel api 26+
        val channelId = "My_Channel_ID"
        createNotificationChannel(channelId)

        // Create an explicit intent for an activity in this app
        val intent = Intent(mContext, MainActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0)


        val buttonIntent = Intent(mContext, MainActivity::class.java)
        buttonIntent.apply {
            action = "Do Pending Task"
            putExtra("My Favorite Color", "RED Color")
        }

        val buttonPendingIntent = PendingIntent.getBroadcast(mContext, 0, buttonIntent, 0)

        val notificationBuilder = NotificationCompat.Builder(mContext, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("NotifyApp")
            .setContentText(""+UUID.randomUUID())
            .setShowWhen(true)
            .setWhen(System.currentTimeMillis())
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .addAction(R.mipmap.ic_launcher, "Do Task", buttonPendingIntent)

        with(NotificationManagerCompat.from(mContext)) {
            notify(1, notificationBuilder.build())
        }
        //UUID.randomUUID()
    }

    private fun createNotificationChannel(channelId: String) {
        // Create the NotificationChannel, but only on API 26+ (Android 8.0) because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "My Channel"
            val channelDescription = "Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(channelId, name, importance)
            channel.apply {
                description = channelDescription
            }

            // Finally register the channel with system
            val notificationManager =
                mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}
