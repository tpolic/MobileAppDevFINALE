package com.example.finale.view

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.finale.R
import com.example.finale.databinding.EventListItemBinding
import com.example.finale.databinding.FragmentEventListBinding
import com.example.finale.view.adapter.EventsAdapter
import com.example.finale.view.detail.NotificationView


class EventFragment : Fragment(R.layout.fragment_event_list) {
   private lateinit var binding: FragmentEventListBinding
   private val viewModel: EventListViewModel by viewModels()

    private val eventsAdapter = EventsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventListBinding.bind(view)

        binding.eventRecyclerView.adapter = eventsAdapter


        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.eventRecyclerView)

        viewModel.eventsData.observe(viewLifecycleOwner, Observer {
            eventsAdapter.updateData(it)
        })

        viewModel.getData()
    }

}