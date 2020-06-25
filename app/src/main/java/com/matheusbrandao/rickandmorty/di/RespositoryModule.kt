package com.matheusbrandao.rickandmorty.di

import com.matheusbrandao.rickandmorty.data.api.ApiRepositoryImpl
import com.matheusbrandao.rickandmorty.domain.repository.ApiRepository
import org.koin.dsl.module.module

val repositoryModule = module {

    factory {
        ApiRepositoryImpl(
            get()
        ) as ApiRepository
    }
}