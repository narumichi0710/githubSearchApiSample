package com.narumichi.githubsearchapisample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.narumichi.githubsearchapisample.databinding.ItemListSearchBinding
import com.narumichi.githubsearchapisample.databinding.ListSearchFragmentBinding
import com.narumichi.githubsearchapisample.models.SearchItem
import com.narumichi.githubsearchapisample.other.DataBindingAdapter
import com.narumichi.githubsearchapisample.other.bind
import com.narumichi.githubsearchapisample.other.toggle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListSearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ListSearchFragmentBinding.inflate(inflater, container, false)
        .bind(viewLifecycleOwner) {
            viewModel.responseListSearch.observe(viewLifecycleOwner) { item ->
                item?.data?.items?.let { items ->
                    if (items.isNullOrEmpty()) it.progressBar.toggle(true)
                    else it.progressBar.toggle(false)

                    it.searchList.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = SearchItemAdapter(items)
                    }
                }
            }
        }

    inner class SearchItemAdapter(items: List<SearchItem>?) :
        DataBindingAdapter<ItemListSearchBinding>(viewLifecycleOwner) {
        override fun onCreateViewDataBinding(
            layoutInflater: LayoutInflater,
            parent: ViewGroup,
            viewType: Int
        ): ItemListSearchBinding = ItemListSearchBinding.inflate(layoutInflater, parent, false)

        private val listSearch = items
        override fun onBindViewDataBinding(binding: ItemListSearchBinding, position: Int) {
            binding.apply {
                lifecycleOwner = viewLifecycleOwner
                searchListData = listSearch?.getOrNull(position)
            }
        }

        override fun getItemCount(): Int = listSearch?.count() ?: 0
    }

}

