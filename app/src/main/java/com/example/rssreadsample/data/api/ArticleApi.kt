package com.example.rssreadsample.data.api

import com.example.rssreadsample.data.response.ArticlesResponse

class ArticleApi {

    suspend fun hotentries(): ArticlesResponse {
        return ApiCreator().create(ArticleApiService::class.java).hotentries().body()!!
    }
}
