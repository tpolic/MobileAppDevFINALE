package com.example.finale.data.apiService

import com.example.finale.data.model.Events
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface EventsApiService {
    @GET("lcero65/eventApi/{jsonName}")
    suspend fun getEvents(@Path("jsonName") name: String): Events

    companion object {
        private const val baseUrl = "https://my-json-server.typicode.com/"

        val client: EventsApiService = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventsApiService::class.java)
    }

}