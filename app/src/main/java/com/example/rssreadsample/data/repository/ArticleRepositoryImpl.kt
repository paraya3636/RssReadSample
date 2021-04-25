package com.example.rssreadsample.data.repository

import com.example.rssreadsample.data.api.ArticleApi
import com.example.rssreadsample.data.mapper.ArticleMapper
import com.example.rssreadsample.domain.model.Article
import com.example.rssreadsample.domain.model.ArticleType
import com.example.rssreadsample.domain.repository.ArticleRepository

class ArticleRepositoryImpl : ArticleRepository {
    override suspend fun articleList(articleType: ArticleType): List<Article> {

        val api = ArticleApi()
        val articles = when (articleType) {
            ArticleType.Social -> api.socialArticles()
            ArticleType.Economics -> api.economicsArticles()
            ArticleType.Life -> api.lifeArticles()
            else -> api.generalArticles()
        }

        return ArticleMapper().map(articles.itemList ?: emptyList())
    }
}
