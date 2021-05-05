package com.example.finale.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.finale.R
import com.example.finale.databinding.FragmentDetailEventBinding

class DetailEventFragment : Fragment(R.layout.fragment_detail_event) {
    private lateinit var binding: FragmentDetailEventBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailEventBinding.bind(view)

    }
}