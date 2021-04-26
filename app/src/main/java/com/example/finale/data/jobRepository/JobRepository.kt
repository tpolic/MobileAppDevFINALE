package com.example.finale.data.jobRepository

import com.example.finale.data.apiService.JobApiService

class JobRepository (
    private val apiService: JobApiService = JobApiService.client
    )
    {
        suspend fun getHeros(name: String = "man") = apiService.getHeros(name)
    }
