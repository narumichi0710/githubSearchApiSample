package com.narumichi.githubsearchapisample.models

data class ResponseListSearch(
    val data: List<SearchItem>? = listOf()
)