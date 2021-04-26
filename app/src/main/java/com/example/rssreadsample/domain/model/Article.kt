package com.example.rssreadsample.domain.model

import java.util.*

data class Article(
        val title: String,
        val description: String,
        val imageUrl: String,
        val date: Date,
        val webSiteUrl: String
)