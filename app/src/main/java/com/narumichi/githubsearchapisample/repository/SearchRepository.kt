package com.narumichi.githubsearchapisample.repository

import com.narumichi.githubsearchapisample.api.ApiHelperImpl
import com.narumichi.githubsearchapisample.models.ResponseListSearch
import retrofit2.Response
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val apiHelperImpl: ApiHelperImpl
) {
    suspend fun getListSearch(): Response<ResponseListSearch> = apiHelperImpl.getListSearch()
}