package com.matheusbrandao.rickandmorty.presentation.location

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.matheusbrandao.rickandmorty.domain.interactor.location.FindLocationsUseCase
import com.matheusbrandao.rickandmorty.presentation.BaseViewModel
import timber.log.Timber

class LocationListViewModel(
    context: Application,
    private val findLocationsUseCase: FindLocationsUseCase
) : BaseViewModel(context) {

    private val _items = MutableLiveData<List<LocationBinding>>().apply { value = emptyList() }
    val items: LiveData<List<LocationBinding>>
        get() = _items

    fun getLocations() {
        _dataLoading.value = true

        findLocationsUseCase.execute(
            null,
            {
                val listLocations = it.map { location ->
                    LocationDataMapper.fromDomain(
                        location
                    )
                }

                _items.postValue(
                    listLocations
                )
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
        findLocationsUseCase.dispose()
    }
}