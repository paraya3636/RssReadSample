package com.example.rssreadsample.data.mapper

import com.example.rssreadsample.data.response.HatenaArticlesResponse
import com.example.rssreadsample.domain.model.Article
import java.text.SimpleDateFormat
import java.util.*

class ArticleMapper : Mapper<HatenaArticlesResponse.Item, Article> {
    override fun map(source: HatenaArticlesResponse.Item): Article {
        return Article(
                source.title ?: "",
                source.description ?: "",
                source.imageUrl ?: "",
                SimpleDateFormat("yyyy-MM-DD'T'hh:mm:ss'Z'", Locale.getDefault()).parse(source.date!!)!!,
                source.link ?: ""
        )
    }
}
