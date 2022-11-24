package com.stefan.prak08.Api

data class ArticlesJson(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)