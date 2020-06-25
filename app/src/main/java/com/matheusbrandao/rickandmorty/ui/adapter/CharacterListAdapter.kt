package com.matheusbrandao.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.matheusbrandao.rickandmorty.databinding.ItemPersonagemListBinding
import com.matheusbrandao.rickandmorty.presentation.character.CharacterBinding
import com.matheusbrandao.rickandmorty.ui.holder.CharacterViewHolder

class CharacterListAdapter(items: List<CharacterBinding>) :
    BaseListAdapter<CharacterBinding, CharacterViewHolder>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemPersonagemListBinding.inflate(
            layoutInflater, parent, false
        )
        return CharacterViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItemByPosition(position)
        holder.bind(character)
    }
}