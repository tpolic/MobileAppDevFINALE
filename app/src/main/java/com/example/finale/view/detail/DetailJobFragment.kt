package com.example.finale.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.finale.R
import com.example.finale.databinding.FragmentDetailJobBinding


class DetailJobFragment : Fragment(R.layout.fragment_detail_job) {
    private lateinit var binding: FragmentDetailJobBinding
    private val args: DetailJobFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailJobBinding.bind(view)

        with(binding){
            heroIv.loadUrlImg(args.hero.image.url)
            heroNameTv.text = args.hero.name


        }
    }
}

fun ImageView.loadUrlImg(url: String?) {
    url?.let {
        Glide.with(this).load(it).into(this)
    }
}