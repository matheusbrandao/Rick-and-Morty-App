package com.matheusbrandao.rickandmorty.di

import com.matheusbrandao.rickandmorty.domain.interactor.character.FindCharactersUseCase
import com.matheusbrandao.rickandmorty.domain.interactor.episode.FindEpisodesUseCase
import com.matheusbrandao.rickandmorty.domain.interactor.location.FindLocationsUseCase
import org.koin.dsl.module.module

val domainModule = module {

    factory {
        FindCharactersUseCase(
            get(),
            get()
        )
    }

    factory {
        FindLocationsUseCase(
            get(),
            get()
        )
    }

    factory {
        FindEpisodesUseCase(
            get(),
            get()
        )
    }
}