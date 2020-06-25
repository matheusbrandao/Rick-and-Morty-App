package com.matheusbrandao.rickandmorty.presentation.character

import java.io.Serializable

data class CharacterBinding(
    val status: String,
    val name: String,
    val image: String,
    val species: String
) : Serializable