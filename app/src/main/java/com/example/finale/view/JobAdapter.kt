package com.example.finale.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finale.R
import com.example.finale.data.model.Hero
import com.example.finale.databinding.JobListItemBinding

class JobAdapter (private val onTap: (hero: Hero) -> Unit): RecyclerView.Adapter<JobAdapter.HeroItem>() {

    private var data: List<Hero> = listOf()

    class HeroItem(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding  = JobListItemBinding.bind(itemView)

        fun configure(hero: Hero) {
           // binding.heroNameTv.text = hero.name
            binding.heroIv.loadUrl(hero.image.url)
        }
    }

    fun updateData(heroData: List<Hero>) {
        data = heroData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.job_list_item, parent, false)
        return HeroItem(itemView)
    }

    override fun onBindViewHolder(holder: HeroItem, position: Int) {
        val hero = data[position]
        holder.configure(hero)
        holder.itemView.setOnClickListener {
            onTap(hero)
        }
    }
}

fun ImageView.loadUrl(url: String) {
    url?.let {
        Glide.with(this).load(it).into(this)
    }
}




