package com.stefan.prak08.adapter

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.stefan.prak08.R
import com.stefan.prak08.databinding.NewsItemBinding
import com.stefan.prak08.Api.Article
/**
 * @author Stefanus - 2072013
 * **
 */

class NewsArticleAdapter(val articles: ArrayList<Article>) : Adapter<NewsArticleAdapter.ArticleViewHolder>() {

    private lateinit var articleDataListener: ArticleDataListener
    private lateinit var links: ArrayList<String>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ArticleViewHolder(view)    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.setArticleData(articles[position])
        holder.itemView.setOnClickListener {
            articleDataListener.articleItemClicked(articles[position])
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun setArticleDataListener(articleDataListener: ArticleDataListener){
        this.articleDataListener = articleDataListener
    }

    interface ArticleDataListener{
        fun articleItemClicked(article: Article)
    }

    inner class ArticleViewHolder(itemView: View): ViewHolder(itemView) {
        private lateinit var binding: NewsItemBinding
//        var itemTitle : TextView = itemView.findViewById(R.id.tv_title)
//        val itemDetail : TextView = itemTitle.findViewById(R.id.tv_all_desc)
//
//        init {
//            binding = NewsItemBinding.bind(itemView)
//            val position: Int = adapterPosition
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse(links[position])
//            startActivity(itemView.context,intent,null)
//        }

        fun setArticleData(article: Article){
            binding.tvTitle.text = article.title
            binding.tvPublishedDate.text = article.publishedAt
            binding.tvAuthor.text = article.author
            binding.tvDescription.text = article.description
            binding.button.text = article.author.subSequence(0,1)
        }
    }

}