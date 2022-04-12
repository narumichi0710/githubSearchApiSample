package com.narumichi.githubsearchapisample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.narumichi.githubsearchapisample.R
import dagger.hilt.android.AndroidEntryPoint

// アプリ起動時にDIの起点となるActivityを指定する(Hilt)
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}