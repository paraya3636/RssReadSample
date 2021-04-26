package com.example.rssreadsample.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rssreadsample.domain.model.ArticleType

class ArticleTabAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = ArticleType.values().size

    override fun createFragment(position: Int): Fragment {
        return ArticleListFragment.newInstance(articleTypeByPosition(position))
    }

    private fun articleTypeByPosition(position: Int): ArticleType {
        return when (position) {
            1 -> ArticleType.Social
            2 -> ArticleType.Economics
            3 -> ArticleType.Life
            else -> ArticleType.General
        }
    }
}