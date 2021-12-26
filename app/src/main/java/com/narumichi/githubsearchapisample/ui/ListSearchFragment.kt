package com.narumichi.githubsearchapisample.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.narumichi.githubsearchapisample.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListSearchFragment : Fragment(R.layout.list_search_fragment) {

    private val viewModel : SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("dsdsdsdssd", viewModel.listSearch.value?.data.toString())

    }
}
