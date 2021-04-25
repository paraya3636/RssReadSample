package com.example.rssreadsample.data.api

import com.example.rssreadsample.data.response.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleApiService {
    @GET("/hotentry.rss")
    suspend fun generalArticles(): Response<ArticlesResponse>

    @GET("/hotentry/{category}.rss")
    suspend fun articles(@Path("category") category: String): Response<ArticlesResponse>
}