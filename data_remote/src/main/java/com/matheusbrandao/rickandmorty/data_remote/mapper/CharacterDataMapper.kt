package com.matheusbrandao.rickandmorty.data_remote.mapper

import com.matheusbrandao.rickandmorty.data_remote.model.CharacterDataEntity
import com.matheusbrandao.rickandmorty.domain.CharacterData

object CharacterDataMapper : Mapper<CharacterDataEntity, CharacterData> {

    override fun fromRemote(remote: CharacterDataEntity): CharacterData {
        return CharacterData(
            info = CharacterInfoMapper.fromRemote(remote.info),
            characters = remote.results.map(CharacterMapper::fromRemote)
        )
    }

    override fun toRemote(domain: CharacterData): CharacterDataEntity {
        TODO("Not yet implemented")
    }
}