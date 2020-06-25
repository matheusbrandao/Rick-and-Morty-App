package com.matheusbrandao.rickandmorty.data_remote.model

import com.google.gson.annotations.SerializedName

data class CharacterDataEntity(
    @SerializedName(value = "info") val info: CharacterInfoEntity,
    @SerializedName(value = "results") val results: List<CharacterEntity>
)
