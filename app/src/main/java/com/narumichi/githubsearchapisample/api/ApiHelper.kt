package com.narumichi.githubsearchapisample.api

import com.narumichi.githubsearchapisample.model.ResponseListSearch
import retrofit2.Response

interface ApiHelper {
    suspend fun getListSearch(value: String): Response<ResponseListSearch>
}