package com.narumichi.githubsearchapisample.other

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("binding_toggle")
fun View.toggle(isVisible: Boolean?) {
    visibility = if (isVisible == true) {
        View.VISIBLE
    } else {
        View.GONE
    }
}