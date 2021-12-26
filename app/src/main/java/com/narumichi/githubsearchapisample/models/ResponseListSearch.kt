package com.narumichi.githubsearchapisample.models


data class ResponseListSearch(
    val status: String? = "",
    val items: List<SearchItem>? = listOf()
)