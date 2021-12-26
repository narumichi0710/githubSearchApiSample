package com.narumichi.githubsearchapisample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narumichi.githubsearchapisample.models.ResponseListSearch
import com.narumichi.githubsearchapisample.other.Resource
import com.narumichi.githubsearchapisample.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


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
        searchRepository.getListSearch().let {
            if (it.isSuccessful) {
                _listSearch.postValue(Resource.success(it.body()))
            } else {
                _listSearch.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}