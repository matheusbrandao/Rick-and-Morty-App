package com.matheusbrandao.rickandmorty.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.rickandmorty.databinding.ItemEpisodeListBinding
import com.matheusbrandao.rickandmorty.databinding.ItemLocationListBinding
import com.matheusbrandao.rickandmorty.presentation.character.CharacterBinding
import com.matheusbrandao.rickandmorty.databinding.ItemPersonagemListBinding
import com.matheusbrandao.rickandmorty.presentation.episode.EpisodeBinding
import com.matheusbrandao.rickandmorty.presentation.location.LocationBinding

class EpisodeViewHolder(val binding: ItemEpisodeListBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(episode: EpisodeBinding) {
        binding.episode = episode
        binding.executePendingBindings()
    }
}