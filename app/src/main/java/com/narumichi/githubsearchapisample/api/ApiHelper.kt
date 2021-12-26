package com.narumichi.githubsearchapisample.api

import com.narumichi.githubsearchapisample.models.ResponseListSearch
import retrofit2.Response

interface ApiHelper {
    suspend fun getSearchRepositories(): Response<ResponseListSearch>
}