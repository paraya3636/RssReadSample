package com.example.rssreadsample.domain.repository

import com.example.rssreadsample.domain.model.Article

interface ArticleRepository {
    suspend fun articleList(): List<Article>
}
