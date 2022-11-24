package com.stefan.prak08.Api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

/**
 * @author Vina Anjelina - 2072022
 * **
 */

@Parcelize
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
//    val source: @RawValue Source,
    val title: String,
    val url: String,
    val urlToImage: String
) : Parcelable