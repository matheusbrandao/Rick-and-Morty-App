package com.matheusbrandao.rickandmorty.presentation.episode

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.matheusbrandao.rickandmorty.domain.interactor.episode.FindEpisodesUseCase
import com.matheusbrandao.rickandmorty.presentation.BaseViewModel
import timber.log.Timber

class EpisodeListViewModel(
    context: Application,
    private val findEpisodesUseCase: FindEpisodesUseCase
) : BaseViewModel(context) {

    private val _items = MutableLiveData<List<EpisodeBinding>>().apply { value = emptyList() }
    val items: LiveData<List<EpisodeBinding>>
        get() = _items

    fun getEpisodes() {
        findEpisodesUseCase.execute(
            null,
            {
                val listEpisodes = it.map { episode ->
                    EpisodeDataMapper.fromDomain(
                        episode
                    )
                }

                _items.postValue(
                    listEpisodes
                )
            },
            {
                Timber.e("Error: ${it.message.toString()}")
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        findEpisodesUseCase.dispose()
    }
}