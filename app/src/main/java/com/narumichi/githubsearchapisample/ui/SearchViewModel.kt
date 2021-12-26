package com.narumichi.githubsearchapisample.ui

import androidx.lifecycle.ViewModel
import com.narumichi.githubsearchapisample.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {


}
