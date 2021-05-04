package com.example.finale.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.finale.R
import com.example.finale.databinding.FragmentEventListBinding
import com.example.finale.view.adapter.EventsAdapter


class EventFragment : Fragment(R.layout.fragment_event_list) {
   private lateinit var binding: FragmentEventListBinding
   private val viewModel: EventListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventListBinding.bind(view)

        val eventsAdapter = EventsAdapter{
            it
        }

        binding.eventRecyclerView.adapter = eventsAdapter

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.eventRecyclerView)


        viewModel.eventsData.observe(viewLifecycleOwner, Observer {
            eventsAdapter.updateData(it)
        })

        viewModel.getData()
    }

}