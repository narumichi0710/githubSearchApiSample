package com.narumichi.githubsearchapisample.models


data class ResponseListSearch(
    val status: String? = "",
    val data: List<SearchItem>? = listOf()
)