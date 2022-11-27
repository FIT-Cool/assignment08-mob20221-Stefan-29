package com.stefan.prak08

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
            binding.icContent.tvTitle?.text  = news.title
            binding.icContent.tvPublishedDate?.text = news.publishedAt
            binding.icContent.tvAuthor?.text = news.author
            binding.icContent.tvDescription?.text = news.description
        }
    }
}