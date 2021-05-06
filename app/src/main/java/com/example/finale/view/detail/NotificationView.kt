package com.example.finale.view.detail

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.*
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.finale.R
import com.example.finale.databinding.EventListItemBinding


class NotificationView : Fragment(R.layout.event_view) {
    private lateinit var binding: EventListItemBinding
    private val notificationId = 101
    private val CHANNEL_ID = "com.example.finale"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = EventListItemBinding.bind(view)

        with(binding) {


        }
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notifications title"
            val descriptionText = "Notification description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager? = context?.let { getSystemService(it, NotificationManager::class.java) }
            notificationManager?.createNotificationChannel(channel)
        }

    }
    private fun sendNotification(){
        val builder = context?.let {
            NotificationCompat.Builder(it, CHANNEL_ID)
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_light)
                    .setContentTitle("This is a reminder for the upcomiong event")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        }
        with(context?.let { NotificationManagerCompat.from(it) }){
            if (builder != null) {
                this?.notify(notificationId, builder.build())
            }
        }

    }
}
