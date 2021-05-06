package com.example.finale.data.jobRepository

import com.example.finale.data.apiService.EventsApiService

class EventsRepository (
    private val apiService: EventsApiService = EventsApiService.client
)
{
    suspend fun getEvents(jsonName: String = "db") = apiService.getEvents(jsonName)
}