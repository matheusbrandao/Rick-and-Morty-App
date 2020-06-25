package com.matheusbrandao.rickandmorty.di

import com.matheusbrandao.rickandmorty.presentation.character.CharacterListViewModel
import com.matheusbrandao.rickandmorty.presentation.episode.EpisodeListViewModel
import com.matheusbrandao.rickandmorty.presentation.location.LocationListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {

    viewModel {
        CharacterListViewModel(
            androidApplication(),
            get()
        )
    }

    viewModel {
        LocationListViewModel(
            androidApplication(),
            get()
        )
    }

    viewModel {
        EpisodeListViewModel(
            androidApplication(),
            get()
        )
    }
}