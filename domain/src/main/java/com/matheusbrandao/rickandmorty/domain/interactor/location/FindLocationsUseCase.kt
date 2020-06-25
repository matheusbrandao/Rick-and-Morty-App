package com.matheusbrandao.rickandmorty.domain.interactor.location

import com.matheusbrandao.rickandmorty.domain.Location
import com.matheusbrandao.rickandmorty.domain.executor.PostExecutionThread
import com.matheusbrandao.rickandmorty.domain.interactor.ObservableUseCase
import com.matheusbrandao.rickandmorty.domain.repository.ApiRepository
import io.reactivex.Observable

class FindLocationsUseCase(
    postExecutionThread: PostExecutionThread,
    private val characterRepository: ApiRepository
) : ObservableUseCase<List<Location>, Unit>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit?): Observable<List<Location>> {
        return characterRepository.findLocations()
    }
}