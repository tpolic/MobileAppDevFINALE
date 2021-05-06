package com.example.finale.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Events (
    val events: List<Event>
): Parcelable

@Parcelize
data class Event (
    val name: String,
    val location: Location,
    val link: String
): Parcelable

@Parcelize
data class Location (
    val latitude: Double,
    val longitude: Double
):Parcelable
