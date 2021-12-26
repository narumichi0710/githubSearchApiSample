package com.narumichi.githubsearchapisample.api

import com.narumichi.githubsearchapisample.models.ResponseListSearch
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getListSearch(): Response<ResponseListSearch> = apiService.getListSearch()
}
