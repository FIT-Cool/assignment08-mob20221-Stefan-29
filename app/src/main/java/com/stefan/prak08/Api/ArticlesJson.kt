package com.stefan.prak08.Api

/**
 * @author Stefanus - 2072013
 * **
 */


data class ArticlesJson(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)