package com.matheusbrandao.rickandmorty.data_remote.mapper

import com.matheusbrandao.rickandmorty.data_remote.model.CharacterEntity
import com.matheusbrandao.rickandmorty.domain.Character

object InfoDataMapper : Mapper<CharacterEntity, Character> {

    override fun fromRemote(remote: CharacterEntity): Character {
        return Character(
            status = remote.status,
            name = remote.name,
            image = remote.image
        )
    }

    override fun toRemote(domain: Character): CharacterEntity {
        TODO("Not yet implemented")
    }
}