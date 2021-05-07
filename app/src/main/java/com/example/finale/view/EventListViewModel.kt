package com.example.finale.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finale.data.jobRepository.EventsRepository
import com.example.finale.data.model.Event
import com.example.finale.data.model.Events
import com.example.finale.data.model.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventListViewModel (

    private val repository: EventsRepository = EventsRepository()
): ViewModel(){

    val eventsData: MutableLiveData<List<Event>> = MutableLiveData()
    fun getData(name: String = "db") {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getEvents(name)
            println("test123 ${data.events}")
            eventsData.postValue(data.events)
        }
    }
}
