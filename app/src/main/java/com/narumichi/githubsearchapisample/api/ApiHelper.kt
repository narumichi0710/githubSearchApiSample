package com.narumichi.githubsearchapisample.api

import retrofit2.Response

interface ApiHelper {
    suspend fun getSearchRepositories(): Response<String>
}