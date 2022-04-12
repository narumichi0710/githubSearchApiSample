package com.narumichi.githubsearchapisample.model


data class ResponseListSearch(
    val status: String? = "",
    val items: List<SearchItem>? = listOf()
)