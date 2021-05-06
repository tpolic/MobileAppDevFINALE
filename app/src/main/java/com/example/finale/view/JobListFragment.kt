package com.example.finale.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.finale.R
import com.example.finale.databinding.FragmentJobListBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.finale.data.model.Job
import com.example.finale.view.adapter.JobAdapter

class JobListFragment : Fragment(R.layout.fragment_job_list) {
    private lateinit var binding: FragmentJobListBinding
    private val viewModel: JobListViewModel by viewModels()

    private val heroAdapter = JobAdapter{
        navigateToDetail(it)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentJobListBinding.bind(view)

        binding.recyclerView.adapter = heroAdapter

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerView)

        viewModel.jobData.observe(viewLifecycleOwner, Observer {
            heroAdapter.updateData(it)
        })

        viewModel.getData()
    }

    private fun navigateToDetail(job:Job) {
        val directions = JobListFragmentDirections.actionJobListFragmentToDetailJobFragment(job)
        findNavController().navigate(directions)
    }

}
