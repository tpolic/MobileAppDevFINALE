package com.example.finale.view.detail

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.example.finale.R
import com.example.finale.databinding.FragmentDetailEventBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.SupportMapFragment

class DetailEventFragment : Fragment(R.layout.fragment_detail_event){
    private lateinit var binding: FragmentDetailEventBinding
    private val args: DetailEventFragmentArgs by navArgs()


    private val notificationId = 101
    private val CHANNEL_ID = "com.example.finale"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailEventBinding.bind(view)

        with(binding){
            eventDetailName.text = args.event.name
            eventDescription.text = args.event.description
            //println("test123 ${args.event.location}")
            binding.notifyButton.setOnClickListener {
                val builder = context?.let {
                    NotificationCompat.Builder(it, CHANNEL_ID)
                        .setSmallIcon(R.drawable.common_google_signin_btn_icon_light)
                        .setContentTitle("${args.event.name}")
                        .setContentText("Start day of this event is on ${args.event.start}")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                }
                with(context?.let { NotificationManagerCompat.from(it) }){
                    if (builder != null) {
                        this?.notify(notificationId, builder.build())
                    }
                }
            }

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
            val notificationManager: NotificationManager? = context?.let { ContextCompat.getSystemService(it, NotificationManager::class.java) }
            notificationManager?.createNotificationChannel(channel)
        }

    }

}