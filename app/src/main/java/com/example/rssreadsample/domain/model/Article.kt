package com.example.rssreadsample.domain.model

import java.util.*

data class Article(
        val Title: String,
        val Description: String,
        val ImageUrl: String,
        val Date: Date,
        val WebSiteUrl: String
) {
}