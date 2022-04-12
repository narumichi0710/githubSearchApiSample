package com.narumichi.githubsearchapisample.model

// レスポンスのデータを管理するためのデータクラス
data class ResponseListSearch(
    val status: String? = "",
    val items: List<SearchItem>? = listOf()
)