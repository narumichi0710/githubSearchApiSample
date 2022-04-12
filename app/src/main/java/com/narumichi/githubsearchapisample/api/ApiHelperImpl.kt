package com.narumichi.githubsearchapisample.api

import com.narumichi.githubsearchapisample.model.ResponseListSearch
import retrofit2.Response
import javax.inject.Inject

// ApiHelper関数に機能を提供するための具象クラス
// コンストラクタにApiServiceの依存性を注入しているため、インスタンスを新しく生成する必要は無い
class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getListSearch(value: String): Response<ResponseListSearch> = apiService.getListSearch(value)
}