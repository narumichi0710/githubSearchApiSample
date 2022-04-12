package com.narumichi.githubsearchapisample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.narumichi.githubsearchapisample.R
import com.narumichi.githubsearchapisample.model.ResponseListSearch
import com.narumichi.githubsearchapisample.model.SearchItem
import com.narumichi.githubsearchapisample.other.*
import dagger.hilt.android.AndroidEntryPoint

// アプリ起動時にDIの起点となるFragmentを指定する(Hilt)
@AndroidEntryPoint
class ListSearchFragment : Fragment() {

    // ViewModelを定義(AAC)
    private val viewModel: SearchViewModel by viewModels()

    // Viewを生成して返すライフサイクル
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composable(R.navigation.nav_global) {

        // ComposeはAPIから受け取ったデータのみ表示しており、画面遷移、画面制御はFragmentで行っている
        // ※ViewControllerの上にSwiftUIのレイアウトを重ねているイメージ
        List(viewModel.responseListSearch.observeAsState())
    }

    // リストを表示しているView
    @Composable
    private fun List(
        searchList: State<Resource<ResponseListSearch>?>
    ) {
        LazyColumn {
            searchList.value?.data?.items?.let {
                items(it) { item ->
                    Cell(item)
                }
            }
        }
    }

    // セルを表示しているView
    @Composable
    private fun Cell(items: SearchItem) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(8.dp),
            elevation = 8.dp
        ) {
            items.name?.let {
                Text(it, textAlign = TextAlign.Center)
            }
        }
    }

}

