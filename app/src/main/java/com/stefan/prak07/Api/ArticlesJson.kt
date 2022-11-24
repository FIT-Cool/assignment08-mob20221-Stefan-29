package com.stefan.prak07.Api

data class ArticlesJson(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)