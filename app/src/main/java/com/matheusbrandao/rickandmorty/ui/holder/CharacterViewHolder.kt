package com.matheusbrandao.rickandmorty.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.rickandmorty.presentation.character.CharacterBinding
import com.matheusbrandao.rickandmorty.databinding.ItemPersonagemListBinding

class CharacterViewHolder(val binding: ItemPersonagemListBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterBinding) {
        binding.character = character
        binding.executePendingBindings()
    }
}