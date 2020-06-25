package com.matheusbrandao.rickandmorty.di

import com.matheusbrandao.rickandmorty.domain.executor.PostExecutionThread
import com.matheusbrandao.rickandmorty.ui.executor.UiThread
import org.koin.dsl.module.module

val androidModule = module {

    single { this }

    single {
        UiThread() as PostExecutionThread
    }

}