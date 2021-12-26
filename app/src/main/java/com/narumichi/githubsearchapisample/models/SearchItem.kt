package com.narumichi.githubsearchapisample.models

import com.squareup.moshi.Json

class SearchItem(
    val id: Int? = null,
    @Json(name = "full_name")
    var fullName: String? = null
)