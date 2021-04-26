package com.example.finale.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finale.data.jobRepository.JobRepository
import com.example.finale.data.model.Hero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JobListViewModel(

    private val repository: JobRepository = JobRepository()
): ViewModel(){

    val heroData: MutableLiveData<List<Hero>> = MutableLiveData()
    fun getData(name: String = "man") {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getHeros(name)
            heroData.postValue(data.results)
        }
    }
}



