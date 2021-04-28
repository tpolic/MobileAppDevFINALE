package com.example.finale.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Job (
        val id: String,
        val type: String,
        val url: String,
        val createdAt: String?,
        val company: String,
        val companyURL: String?,
        val location: String,
        val title: String,
        val description: String,
        val howToApply: String?,
        val companyLogo: String?
):Parcelable