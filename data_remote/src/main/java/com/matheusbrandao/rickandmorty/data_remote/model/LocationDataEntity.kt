package com.matheusbrandao.rickandmorty.data_remote.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class LocationDataEntity(
    @SerializedName(value = "info") val info: JsonObject,
    @SerializedName(value = "results") val results: List<LocationEntity>
)
