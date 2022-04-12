package com.narumichi.githubsearchapisample.repository

import com.narumichi.githubsearchapisample.api.ApiHelperImpl
import com.narumichi.githubsearchapisample.model.ResponseListSearch
import retrofit2.Response
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val apiHelperImpl: ApiHelperImpl
) {
    suspend fun getListSearch(value: String): Response<ResponseListSearch> = apiHelperImpl.getListSearch(value)
}