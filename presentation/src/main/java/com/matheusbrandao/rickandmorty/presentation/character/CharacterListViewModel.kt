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

    fun getCharacters(currentPage: Int) {
        _dataLoading.value = true

        findCharactersUseCase.execute(
            FindCharactersUseCase.Params(
                page = currentPage),
            {
                val listCharacters = it.map { character ->
                    CharacterDataMapper.fromDomain(
                        character
                    )
                }

                _items.apply {
                    val newList = this.value!!.toMutableList()
                    newList.addAll(listCharacters)
                    value = newList
                }

                _dataLoading.value = false
            },
            {
                Timber.e("Error: ${it.message.toString()}")
                parseErrors(it)
                _dataLoading.value = false
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        findCharactersUseCase.dispose()
    }
}