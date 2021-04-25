package com.example.rssreadsample.data.api

import com.example.rssreadsample.data.response.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArticleApiService {
    @GET("/hotentry.rss")
    suspend fun hotentries(): Response<ArticlesResponse>
}