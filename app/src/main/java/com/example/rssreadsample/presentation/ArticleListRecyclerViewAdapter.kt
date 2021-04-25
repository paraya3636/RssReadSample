package com.example.rssreadsample.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rssreadsample.R
import com.example.rssreadsample.domain.model.Article

class ArticleListRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<ArticleListRecyclerViewAdapter.ViewHolder>() {

    lateinit var dataSet: List<Article>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = dataSet[position]
        holder.titleTextView.text = article.title
        holder.imageView.load(article.imageUrl)
        holder.cardView.setOnClickListener {
            showWebBrowser(article.webSiteUrl)
        }
    }

    override fun getItemCount(): Int = dataSet.size

    private fun showWebBrowser(webPageUrl: String) {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(webPageUrl)))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = view.findViewById(R.id.cardView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }
}