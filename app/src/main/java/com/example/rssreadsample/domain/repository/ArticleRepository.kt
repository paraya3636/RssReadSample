package com.example.rssreadsample.domain.repository

import com.example.rssreadsample.domain.model.Article
import com.example.rssreadsample.domain.model.ArticleType

interface ArticleRepository {
    suspend fun articleList(articleType: ArticleType): List<Article>
}
