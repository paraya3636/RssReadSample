package com.example.rssreadsample.data.api

import com.example.rssreadsample.data.response.HatenaArticlesResponse

class HatenaApi {

    suspend fun generalArticles(): HatenaArticlesResponse {
        return ApiCreator().create(HatenaApiService::class.java).generalArticles().body()!!
    }

    suspend fun socialArticles(): HatenaArticlesResponse {
        return ApiCreator().create(HatenaApiService::class.java).articles("social").body()!!
    }

    suspend fun economicsArticles(): HatenaArticlesResponse {
        return ApiCreator().create(HatenaApiService::class.java).articles("economics").body()!!
    }

    suspend fun lifeArticles(): HatenaArticlesResponse {
        return ApiCreator().create(HatenaApiService::class.java).articles("life").body()!!
    }
}
