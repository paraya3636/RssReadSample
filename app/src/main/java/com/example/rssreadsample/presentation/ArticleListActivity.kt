package com.example.rssreadsample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.rssreadsample.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ArticleListActivity : AppCompatActivity() {

    private val tabLayout: TabLayout by lazy { findViewById(R.id.tabLayout) }
    private val viewPager: ViewPager2 by lazy { findViewById(R.id.viewPager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_list)

        viewPager.adapter = ArticleTabAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabName(position)
        }.attach()
    }

    private fun tabName(position: Int): String {
        return when (position) {
            1 -> "世の中"
            2 -> "政治と経済"
            3 -> "暮らし"
            else -> "総合"
        }
    }
}