package com.example.rssreadsample.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.rssreadsample.R
import com.example.rssreadsample.domain.model.ArticleType
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ArticleListFragment(articleType: ArticleType) : Fragment() {

    private val articleListViewModel by viewModel<ArticleListViewModel> { parametersOf(articleType) }
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ArticleListRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArticleListRecyclerViewAdapter(requireContext())
        recyclerView = view.findViewById(R.id.recyclerView)

        articleListViewModel.articleList.observe(viewLifecycleOwner, Observer {
            adapter.dataSet = it
            recyclerView.adapter = adapter
        })
    }
}