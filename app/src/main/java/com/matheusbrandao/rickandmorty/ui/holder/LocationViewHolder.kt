package com.matheusbrandao.rickandmorty.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.rickandmorty.databinding.ItemLocationListBinding
import com.matheusbrandao.rickandmorty.presentation.character.CharacterBinding
import com.matheusbrandao.rickandmorty.databinding.ItemPersonagemListBinding
import com.matheusbrandao.rickandmorty.presentation.location.LocationBinding

class LocationViewHolder(val binding: ItemLocationListBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(location: LocationBinding) {
        binding.location = location
        binding.executePendingBindings()
    }
}