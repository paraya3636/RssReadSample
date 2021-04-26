package com.example.rssreadsample.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rssreadsample.R
import com.example.rssreadsample.domain.model.ArticleType
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ArticleListFragment : Fragment() {

    private val articleListViewModel by viewModel<ArticleListViewModel> { parametersOf(articleType) }
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ArticleListRecyclerViewAdapter
    private lateinit var articleType: ArticleType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArticleListRecyclerViewAdapter(requireContext())
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager()
        recyclerView.adapter = adapter

        articleListViewModel.articleList().observe(viewLifecycleOwner, Observer {
            adapter.dataSet = it
            adapter.notifyDataSetChanged()
        })
    }

    private fun layoutManager(): GridLayoutManager {
        return GridLayoutManager(requireContext(), 2).apply {
            val lookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position == 0) {
                        2
                    } else {
                        1
                    }
                }
            }
            spanSizeLookup = lookup
        }
    }

    companion object {
        fun createFragment(type: ArticleType): ArticleListFragment {
            return ArticleListFragment().apply {
                articleType = type
            }
        }
    }
}
