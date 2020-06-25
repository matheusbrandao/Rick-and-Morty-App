package com.matheusbrandao.rickandmorty.presentation.character

import com.matheusbrandao.rickandmorty.domain.Character
import com.matheusbrandao.rickandmorty.presentation.Mapper

object CharacterDataMapper :
    Mapper<Character, CharacterBinding> {

    override fun fromDomain(domain: Character): CharacterBinding {
        return CharacterBinding(
            status = domain.status,
            nome = domain.name,
            image = domain.image
        )
    }
}