package com.narumichi.githubsearchapisample.repository

import com.narumichi.githubsearchapisample.api.ApiHelperImpl
import com.narumichi.githubsearchapisample.model.ResponseListSearch
import retrofit2.Response
import javax.inject.Inject

// コンストラクタにApiHelperImplの依存性を注入しているため、インスタンスを新しく生成する必要は無い
class SearchRepository @Inject constructor(
    private val apiHelperImpl: ApiHelperImpl
) {
    // API Call
    suspend fun getListSearch(value: String): Response<ResponseListSearch> = apiHelperImpl.getListSearch(value)
}