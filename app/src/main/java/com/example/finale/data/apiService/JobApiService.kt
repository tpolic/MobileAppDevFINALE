package com.example.finale.data.apiService

import com.example.finale.data.model.HeroResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface JobApiService {
    @GET("search/{name}")
    suspend fun getHeros(@Path("name") name: String): HeroResponse

    companion object {
        private const val baseUrl = "https://www.superheroapi.com/api.php/4360184137327110/"

        val client: JobApiService = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JobApiService::class.java)
    }
}