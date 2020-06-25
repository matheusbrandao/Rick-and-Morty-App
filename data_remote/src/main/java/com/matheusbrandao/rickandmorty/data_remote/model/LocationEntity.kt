package com.matheusbrandao.rickandmorty.data_remote.model

import com.google.gson.annotations.SerializedName

data class LocationEntity(
    @SerializedName(value = "type") val type: String,
    @SerializedName(value = "name") val name: String
)
