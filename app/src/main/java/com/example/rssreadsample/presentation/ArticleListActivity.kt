package com.example.rssreadsample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.rssreadsample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleListActivity : AppCompatActivity() {

    private val articleListViewModel by viewModel<ArticleListViewModel>()
    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recyclerView) }
    private val adapter: ArticleListRecyclerViewAdapter = ArticleListRecyclerViewAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_list)

        articleListViewModel.articleList.observe(this, Observer {
            adapter.dataSet = it
            recyclerView.adapter = adapter
        })
    }
}