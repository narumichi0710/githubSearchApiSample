package com.narumichi.githubsearchapisample.model

import com.squareup.moshi.Json

// レスポンスのデータを管理するためのデータクラス
data class SearchItem(
    val id: Int? = null,
    @Json(name = "name")
    var name: String? = null
)