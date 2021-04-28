package com.example.finale.data.jobRepository

import com.example.finale.data.apiService.JobApiService

class JobRepository (
    private val apiService: JobApiService = JobApiService.client
    )
    {
        suspend fun getJob(pageNo: Int = 3) = apiService.getJob(pageNo)
    }
