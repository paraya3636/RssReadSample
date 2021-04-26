package com.example.rssreadsample.data.api

import com.example.rssreadsample.data.response.HatenaArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HatenaApiService {
    @GET("/hotentry.rss")
    suspend fun generalArticles(): Response<HatenaArticlesResponse>

    @GET("/hotentry/{category}.rss")
    suspend fun articles(@Path("category") category: String): Response<HatenaArticlesResponse>
}