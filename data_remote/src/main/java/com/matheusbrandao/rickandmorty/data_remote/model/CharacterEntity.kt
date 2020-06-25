package com.matheusbrandao.rickandmorty.data_remote.model

import com.google.gson.annotations.SerializedName

data class CharacterEntity(
    @SerializedName(value = "status") val status: String,
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "image") val image: String,
    @SerializedName(value = "species") val species: String
)
