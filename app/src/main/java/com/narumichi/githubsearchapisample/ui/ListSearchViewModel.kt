package com.narumichi.githubsearchapisample.ui

import androidx.lifecycle.*
import com.narumichi.githubsearchapisample.models.ResponseListSearch
import com.narumichi.githubsearchapisample.other.Resource
import com.narumichi.githubsearchapisample.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _listSearch = MutableLiveData<Resource<ResponseListSearch>>()

    val listSearch: LiveData<Resource<ResponseListSearch>>
        get() = _listSearch

    init {
        initListSearch()
    }

    private fun initListSearch() = viewModelScope.launch {
        _listSearch.postValue(Resource.loading(null))
        searchRepository.getListSearch(Random.nextInt(1..5).toString()).let {
            if (it.isSuccessful) {
                _listSearch.postValue(Resource.success(it.body()))
            } else {
                _listSearch.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}

fun generateRandomString(len: Int = 15): String {
    val alphanumerics = CharArray(26) {
        (it + 97).toChar()
    }.toSet()
        .union(CharArray(9) { it -> (it + 48).toChar() }.toSet())
    return (0 until len).map {
        alphanumerics.toList().random()
    }.joinToString("")
}