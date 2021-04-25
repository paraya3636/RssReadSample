package com.example.rssreadsample.data.repository

import com.example.rssreadsample.data.api.ArticleApi
import com.example.rssreadsample.data.mapper.ArticleMapper
import com.example.rssreadsample.domain.model.Article
import com.example.rssreadsample.domain.repository.ArticleRepository

class ArticleRepositoryImpl : ArticleRepository {
    override suspend fun articleList(): List<Article> {
        val hotentries = ArticleApi().hotentries()
        return ArticleMapper().map(hotentries.itemList ?: emptyList())
    }
}
