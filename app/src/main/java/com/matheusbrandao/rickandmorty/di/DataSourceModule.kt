package com.matheusbrandao.rickandmorty.di

import com.matheusbrandao.rickandmorty.data.api.ApiRemoteDataSource
import com.matheusbrandao.rickandmorty.data_remote.ApiRemoteDataSourceImpl
import org.koin.dsl.module.module

val dataSourceModule = module {

    factory {
        ApiRemoteDataSourceImpl(get()) as ApiRemoteDataSource
    }
}