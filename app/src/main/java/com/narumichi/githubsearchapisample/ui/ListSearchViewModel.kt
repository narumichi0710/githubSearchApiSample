package com.narumichi.githubsearchapisample.ui

import androidx.lifecycle.*
import com.narumichi.githubsearchapisample.model.ResponseListSearch
import com.narumichi.githubsearchapisample.other.Resource
import com.narumichi.githubsearchapisample.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt


@HiltViewModel
// ViewModelのコンストラクタにSearchRepositoryの依存性を注入している
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    // レスポンスをpostするために利用するLiveData
    private val _responseListSearch = MutableLiveData<Resource<ResponseListSearch>>()

    // UIに表示するためのデータ
    val responseListSearch: LiveData<Resource<ResponseListSearch>>
        get() = _responseListSearch

    // 初期化
    init {
        initListSearch()
    }

    // API通信を行い_responseListSearchにレスポンスをpostする
    private fun initListSearch() = viewModelScope.launch {
        _responseListSearch.postValue(Resource.loading(null))
        searchRepository.getListSearch(Random.nextInt(1..5).toString()).let {
            if (it.isSuccessful) {
                _responseListSearch.postValue(Resource.success(it.body()))

            } else {
                _responseListSearch.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}