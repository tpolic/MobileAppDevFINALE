package com.example.finale.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTabHost
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.finale.R
import com.example.finale.data.model.Event
import com.example.finale.databinding.FragmentEventListBinding
import com.example.finale.view.adapter.EventsAdapter


class EventFragment : Fragment(R.layout.fragment_event_list) {
   private lateinit var binding: FragmentEventListBinding
   private val viewModel: EventListViewModel by viewModels()

    private val eventsAdapter = EventsAdapter{
        navigateToDetail(it)
        //  println(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventListBinding.bind(view)

        binding.eventRecyclerView.adapter = eventsAdapter

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.eventRecyclerView)

        viewModel.eventsData.observe(viewLifecycleOwner, Observer {
            //println("test12345${it.size}")
            eventsAdapter.updateData(it)
        })

        viewModel.getData()
    }

    private fun navigateToDetail(event: Event) {


        val directions = EventFragmentDirections.actionEventFragmentToDetailEventFragment(event)
        findNavController().navigate(directions)
    }
}