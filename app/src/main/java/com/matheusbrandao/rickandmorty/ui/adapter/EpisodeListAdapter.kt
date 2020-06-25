package com.matheusbrandao.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.matheusbrandao.rickandmorty.databinding.ItemEpisodeListBinding
import com.matheusbrandao.rickandmorty.presentation.episode.EpisodeBinding
import com.matheusbrandao.rickandmorty.ui.holder.EpisodeViewHolder

class EpisodeListAdapter(items: List<EpisodeBinding>) :
    BaseListAdapter<EpisodeBinding, EpisodeViewHolder>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemEpisodeListBinding.inflate(
            layoutInflater, parent, false
        )
        return EpisodeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = getItemByPosition(position)
        holder.bind(episode)
    }
}