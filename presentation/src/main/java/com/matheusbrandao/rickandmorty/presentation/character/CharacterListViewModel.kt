package com.matheusbrandao.rickandmorty.presentation.character

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.matheusbrandao.rickandmorty.domain.interactor.character.FindCharactersUseCase
import com.matheusbrandao.rickandmorty.presentation.BaseViewModel
import timber.log.Timber

class CharacterListViewModel(
    context: Application,
    private val findCharactersUseCase: FindCharactersUseCase
) : BaseViewModel(context) {

    private val _items = MutableLiveData<List<CharacterBinding>>().apply { value = emptyList() }
    val items: LiveData<List<CharacterBinding>>
        get() = _items

    fun getCharacters() {
        findCharactersUseCase.execute(
            null,
            {
                val listCharacters = it.map { character ->
                    CharacterDataMapper.fromDomain(
                        character
                    )
                }

                _items.postValue(
                    listCharacters
                )
            },
            {
                Timber.e("Error: ${it.message.toString()}")
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        findCharactersUseCase.dispose()
    }
}