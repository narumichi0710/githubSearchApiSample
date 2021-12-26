package com.narumichi.githubsearchapisample.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.narumichi.githubsearchapisample.R
import com.narumichi.githubsearchapisample.databinding.ListSearchFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListSearchFragment : Fragment(R.layout.list_search_fragment) {

    private val viewModel: SearchViewModel by viewModels()
    private var _binding: ListSearchFragmentBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listSearch.observe(viewLifecycleOwner) { list ->
            Log.d("dsdsdsdssd", list?.data?.items?.getOrNull(0)?.fullName.toString())
            binding?.fullName?.text = list?.data?.items?.getOrNull(0)?.fullName.toString()
        }

    }
}
