package com.stefan.prak08

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stefan.prak08.Api.Article
import com.stefan.prak08.databinding.ActivityScrollingBinding

/**
 * @author Stefanus - 2072013, Vina Anjelina - 2072022
 * **
 */


class ScrollingActivity : AppCompatActivity() {

private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))


    }
    override fun onStart() {
        super.onStart()
        val news = intent.getParcelableExtra<Article>("news")
        if (news != null) {
            binding.toolbarLayout.title = news.title
            binding.icContent.tvPublishedDate?.text = news.publishedAt
            binding.icContent.tvAuthor?.text = news.author
            binding.icContent.tvDescription?.text = news.description
            binding.icContent.tvContent?.text = news.content
            binding.icContent.tvUrl?.setOnClickListener {
                val webUrl = Uri.parse(news.url);
                //implicit intent
                val webIntent = Intent(Intent.ACTION_VIEW, webUrl);
                if (webIntent.resolveActivity(packageManager)!=null){
                    startActivity(webIntent) //checking if there is such website in the internet
                }
            }


        }
    }
}