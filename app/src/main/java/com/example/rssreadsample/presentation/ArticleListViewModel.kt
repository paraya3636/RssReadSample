package com.example.rssreadsample.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rssreadsample.data.repository.ArticleRepositoryImpl
import com.example.rssreadsample.domain.model.Article
import com.example.rssreadsample.domain.model.ArticleType
import kotlinx.coroutines.launch


class ArticleListViewModel(
        application: Application,
        private val articleType: ArticleType
) : AndroidViewModel(application) {

    val articleList: MutableLiveData<List<Article>> by lazy { MutableLiveData<List<Article>>() }

    init {
        viewModelScope.launch {
            articleList.value = ArticleRepositoryImpl().articleList(articleType)
        }
    }
}