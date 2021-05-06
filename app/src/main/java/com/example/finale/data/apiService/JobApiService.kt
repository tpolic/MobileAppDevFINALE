package com.example.finale.data.apiService

import androidx.lifecycle.MutableLiveData
import com.example.finale.data.model.Job
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JobApiService {
    @GET("positions.json")
    suspend fun getJob(@Query("page")  pageNo: Int): List<Job>

    companion object {
        private const val baseUrl = "https://jobs.github.com/"

        val client: JobApiService = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JobApiService::class.java)
    }
}