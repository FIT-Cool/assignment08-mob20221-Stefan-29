package com.stefan.prak07

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.stefan.prak07.Api.Article
import com.stefan.prak07.Api.ArticlesJson
import com.stefan.prak07.Api.NewsApi
import com.stefan.prak07.Api.Source
import com.stefan.prak07.adapter.NewsArticleAdapter
import com.stefan.prak07.databinding.ActivityMainBinding
//import com.stefan.prak07.entity.Article
//import com.stefan.prak07.entity.ArticleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * @author Stefanus - 2072013, Vina Anjelina - 2072022
 * **
 */


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var articles : ArrayList<Article>
    private lateinit var newsArticleAdapter: NewsArticleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        articles = ArrayList()
        newsArticleAdapter = NewsArticleAdapter(articles)

        //click to view more data
//        newsArticleAdapter.setArticleDataListener(object: NewsArticleAdapter.ArticleDataListener{
//            override fun articleItemClicked(article: Article) {
//                ShowMoreArticleData(article)
//            }
//        })

        binding.rvNews.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvNews.adapter = newsArticleAdapter

        binding.srLayout.setOnRefreshListener {
            fetchArticleData()
            binding.srLayout.isRefreshing = false
        }
    }
    override fun onStart() {
        super.onStart()
        fetchArticleData()
    }

    private fun fetchArticleData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(NewsApi::class.java)
        val call = service.getCurrentNewsData("Twitter", "f0c081794a864a8ca72ebbebc350efc9") //Getting Twitter Related News
        call?.enqueue(object : Callback<ArticlesJson?> {
            override fun onResponse(call: Call<ArticlesJson?>, response: Response<ArticlesJson?>) {
                response.body()!!.articles?.let {
                        articles.addAll(it)
                }
                newsArticleAdapter.notifyItemChanged(0)
            }
            override fun onFailure(call: Call<ArticlesJson?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()

            }

        })

    }

//   private fun ShowMoreArticleData(article: Article){
//       val retrofit = Retrofit.Builder()
//           .baseUrl("https://newsapi.org/v2/")
//           .addConverterFactory(GsonConverterFactory.create())
//           .build()
//       val service = retrofit.create(NewsApi::class.java)
//       val call = service.getCurrentNewsData("Twitter", "f0c081794a864a8ca72ebbebc350efc9") //Getting Twitter Related News
//       call?.enqueue(object : Callback<ArticlesJson?> {
//           override fun onResponse(call: Call<ArticlesJson?>, response: Response<ArticlesJson?>) {
//               response.body()!!.articles?.let {
//                   if (article.source.id == ){
//                       val intent = Intent (this@MainActivity,ScrollingActivity::class.java)
//                       intent.putExtra("article", article)
//                       startActivity(intent)
//                   }
//
//               }
//               newsArticleAdapter.notifyItemChanged(0)
//           }
//           override fun onFailure(call: Call<ArticlesJson?>, t: Throwable) {
//               Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
//
//           }
//
//       })
//  }
}


