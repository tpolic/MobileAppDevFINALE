package com.example.finale.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class HeroResponse (
    val response: String,
    val resultsFor: String,
    val results: List<Hero>
)
@Parcelize
data class Hero (
    val id: String,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections,
    val image: Image
) : Parcelable

@Parcelize
data class Appearance (
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
) : Parcelable

@Parcelize
data class Biography (
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
) : Parcelable

@Parcelize
data class Connections (
    val groupAffiliation: String,
    val relatives: String
) : Parcelable

@Parcelize
data class Image (
    val url: String
) : Parcelable

@Parcelize
data class Powerstats (
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
) : Parcelable

@Parcelize
data class Work (
    val occupation: String,
    val base: String
) : Parcelable
