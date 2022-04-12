package com.narumichi.githubsearchapisample.api

import com.narumichi.githubsearchapisample.model.ResponseListSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/search/repositories")
    suspend fun getListSearch(
        @Query("q") query: String
    ): Response<ResponseListSearch>

}