package com.matheusbrandao.rickandmorty.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.rickandmorty.presentation.episode.EpisodeBinding
import com.matheusbrandao.rickandmorty.ui.adapter.BaseListAdapter

object EpisodeListBindings {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<EpisodeBinding>?) {
        items?.let {
            with(recyclerView.adapter as BaseListAdapter<EpisodeBinding, *>) {
                replaceData(items)
            }
        }
    }
}
