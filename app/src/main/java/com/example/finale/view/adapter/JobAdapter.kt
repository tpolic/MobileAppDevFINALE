package com.example.finale.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finale.R
import com.example.finale.data.model.Job
import com.example.finale.databinding.JobListItemBinding

class JobAdapter (private val onTap: (job: Job) -> Unit): RecyclerView.Adapter<JobAdapter.JobItem>() {

    private var data: List<Job> = listOf()

    class JobItem(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding  = JobListItemBinding.bind(itemView)

        fun configure(job: Job) {
            binding.jobTitle.text = job.company
            job.companyURL?.let { binding.companyLogo.loadUrl(it) }
            binding.jobPosition.text = job.title
           // binding.heroIv.loadUrl(hero.image.url)
        }
    }

    fun updateData(jobData: List<Job>) {
        data = jobData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.job_list_item, parent, false)
        return JobItem(itemView)
    }

    override fun onBindViewHolder(holder: JobItem, position: Int) {
        val job = data[position]
        holder.configure(job)
        holder.itemView.setOnClickListener {
            onTap(job)
        }
    }
}

fun ImageView.loadUrl(url: String) {
    url?.let {
        Glide.with(this).load(it).into(this)
    }
}




