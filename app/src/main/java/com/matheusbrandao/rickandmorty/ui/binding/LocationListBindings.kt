package com.matheusbrandao.rickandmorty.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.rickandmorty.presentation.location.LocationBinding
import com.matheusbrandao.rickandmorty.ui.adapter.BaseListAdapter

object LocationListBindings {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<LocationBinding>?) {
        items?.let {
            with(recyclerView.adapter as BaseListAdapter<LocationBinding, *>) {
                replaceData(items)
            }
        }
    }
}
