package com.matheusbrandao.rickandmorty.data_remote.model

import com.google.gson.annotations.SerializedName

data class EpisodeEntity(
    @SerializedName(value = "episode") val episode: String,
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "air_date") val airDate: String
)
