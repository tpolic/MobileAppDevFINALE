package com.example.finale.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finale.R
import com.example.finale.data.model.Event
import com.example.finale.databinding.EventListItemBinding

class EventsAdapter(private val onTap: (events: Event) -> Unit): RecyclerView.Adapter<EventsAdapter.EventItem>() {

    private var data: List<Event> = listOf()

    class EventItem(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding  = EventListItemBinding.bind(itemView)

        fun configure(events: Event) {
            binding.eventName.text = events.name
        }
    }

    fun updateData(eventData: List<Event>) {
        //println("test1234${eventData}")
        data = eventData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.event_list_item, parent, false)
        return EventItem(itemView)
    }

    override fun onBindViewHolder(holder: EventItem, position: Int) {
        val event = data[position]
        holder.configure(event)
        holder.itemView.setOnClickListener {
            onTap(event)
        }
    }
}