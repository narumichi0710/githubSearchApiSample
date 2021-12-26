package com.narumichi.githubsearchapisample.api

import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getSearchRepositories(): Response<String> {
        TODO("Not yet implemented")
    }
}