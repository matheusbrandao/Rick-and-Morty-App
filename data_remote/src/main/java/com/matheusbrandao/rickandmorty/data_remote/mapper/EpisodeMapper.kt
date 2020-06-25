package com.matheusbrandao.rickandmorty.data_remote.mapper

import com.matheusbrandao.rickandmorty.data_remote.model.EpisodeEntity
import com.matheusbrandao.rickandmorty.domain.Episode

object EpisodeMapper : Mapper<EpisodeEntity, Episode> {

    override fun fromRemote(remote: EpisodeEntity): Episode {
        return Episode(
            name = remote.name,
            episode = remote.episode,
            airDate = remote.airDate
        )
    }

    override fun toRemote(domain: Episode): EpisodeEntity {
        TODO("Not yet implemented")
    }
}