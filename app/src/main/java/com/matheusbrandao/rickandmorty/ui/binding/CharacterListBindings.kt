package com.matheusbrandao.rickandmorty.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.rickandmorty.presentation.character.CharacterBinding
import com.matheusbrandao.rickandmorty.ui.adapter.BaseListAdapter

object CharacterListBindings {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<CharacterBinding>?) {
        items?.let {
            with(recyclerView.adapter as BaseListAdapter<CharacterBinding, *>) {
                replaceData(items)
            }
        }
    }
}
