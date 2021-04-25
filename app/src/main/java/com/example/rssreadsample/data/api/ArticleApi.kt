package com.example.rssreadsample.data.api

import com.example.rssreadsample.data.response.ArticlesResponse

class ArticleApi {

    suspend fun generalArticles(): ArticlesResponse {
        return ApiCreator().create(ArticleApiService::class.java).generalArticles().body()!!
    }

    suspend fun socialArticles(): ArticlesResponse {
        return ApiCreator().create(ArticleApiService::class.java).articles("social").body()!!
    }

    suspend fun economicsArticles(): ArticlesResponse {
        return ApiCreator().create(ArticleApiService::class.java).articles("economics").body()!!
    }

    suspend fun lifeArticles(): ArticlesResponse {
        return ApiCreator().create(ArticleApiService::class.java).articles("life").body()!!
    }
}
