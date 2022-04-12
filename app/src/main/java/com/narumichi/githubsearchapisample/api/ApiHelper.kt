package com.narumichi.githubsearchapisample.api

import com.narumichi.githubsearchapisample.model.ResponseListSearch
import retrofit2.Response

// カプセル化されたリポジトリを介してAPICall出来る様にするためのインターフェイス
interface ApiHelper {
    suspend fun getListSearch(value: String): Response<ResponseListSearch>
}