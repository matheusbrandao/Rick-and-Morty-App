package com.matheusbrandao.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.matheusbrandao.rickandmorty.databinding.ItemLocationListBinding
import com.matheusbrandao.rickandmorty.presentation.location.LocationBinding
import com.matheusbrandao.rickandmorty.ui.holder.LocationViewHolder

class LocationListAdapter(items: List<LocationBinding>) :
    BaseListAdapter<LocationBinding, LocationViewHolder>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemLocationListBinding.inflate(
            layoutInflater, parent, false
        )
        return LocationViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = getItemByPosition(position)
        holder.bind(location)
    }
}