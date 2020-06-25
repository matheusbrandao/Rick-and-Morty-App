package com.matheusbrandao.rickandmorty.data_remote.mapper

import com.matheusbrandao.rickandmorty.data_remote.model.CharacterInfoEntity
import com.matheusbrandao.rickandmorty.domain.CharacterInfo

object CharacterInfoMapper : Mapper<CharacterInfoEntity, CharacterInfo> {

    override fun fromRemote(remote: CharacterInfoEntity): CharacterInfo {
        return CharacterInfo(
            count = remote.count,
            pages = remote.pages,
            next = remote.next ?: "",
            prev = remote.prev ?: ""
        )
    }

    override fun toRemote(domain: CharacterInfo): CharacterInfoEntity {
        TODO("Not yet implemented")
    }
}