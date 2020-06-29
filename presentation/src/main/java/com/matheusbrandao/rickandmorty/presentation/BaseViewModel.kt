package com.matheusbrandao.rickandmorty.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber

abstract class BaseViewModel(context: Application) : AndroidViewModel(context) {

    protected val _dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading

    protected val _errorEvent = MutableLiveData<Event<Any?>>()
    val errorEvent: LiveData<Event<Any?>>
        get() = _errorEvent

    fun dispose() {
        onCleared()
    }

    protected open fun parseErrors(throwable: Throwable) {
        Timber.e(throwable)
        _errorEvent.value = Event("Erro ao buscar dados")
    }
}