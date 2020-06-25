package com.matheusbrandao.rickandmorty.presentation.episode

import com.matheusbrandao.rickandmorty.domain.Episode
import com.matheusbrandao.rickandmorty.presentation.Mapper

object EpisodeDataMapper :
    Mapper<Episode, EpisodeBinding> {

    override fun fromDomain(domain: Episode): EpisodeBinding {
        return EpisodeBinding(
            nome = domain.name,
            episode = domain.episode,
            airDate = domain.airDate
        )
    }
}