package com.example.rssreadsample.presentation

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rssreadsample.domain.model.Article
import com.example.rssreadsample.domain.model.ArticleType
import com.example.rssreadsample.domain.repository.ArticleRepository
import kotlinx.coroutines.launch


class ArticleListViewModel(
        application: Application,
        private val articleRepository: ArticleRepository,
        private val articleType: ArticleType
) : AndroidViewModel(application) {
    
    fun articleList(): LiveData<List<Article>> = articleList
    private val articleList: MutableLiveData<List<Article>> by lazy { MutableLiveData<List<Article>>() }

    init {
        viewModelScope.launch {
            try {
                articleList.value = articleRepository.articleList(articleType)
            } catch (exception: Exception) {
                Toast.makeText(application, "通信エラーが発生しました", Toast.LENGTH_SHORT).show()
            }
        }
    }
}