package com.example.finale.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finale.data.jobRepository.JobRepository
import com.example.finale.data.model.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JobListViewModel(

    private val repository: JobRepository = JobRepository()
): ViewModel(){

    val jobData: MutableLiveData<List<Job>> = MutableLiveData()
    fun getData(pageNo: Int = 3) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getJob(pageNo)
            jobData.postValue(data)
            println("$data")

        }
    }
}



