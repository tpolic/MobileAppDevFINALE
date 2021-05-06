package com.example.finale.view.detail

import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.finale.R
import com.example.finale.databinding.EventListItemBinding


    class NotificationView : Fragment(R.layout.event_list_item) {
        private lateinit var binding: EventListItemBinding
       // private val args: DetailEventFragment by navArgs()

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding = EventListItemBinding.bind(view)

            with(binding){

                binding.notifyButton.setOnClickListener{
                    val builder = NotificationCompat.Builder(requireActivity(), "com.example.finale")
                        .setContentTitle("This is a reminder for the upcomiong event")
                        .setContentText("Hello World!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                    println("ssss")
                }


            }
        }
    }
