package com.matheusbrandao.rickandmorty.domain.interactor.character

import com.matheusbrandao.rickandmorty.domain.Character
import com.matheusbrandao.rickandmorty.domain.executor.PostExecutionThread
import com.matheusbrandao.rickandmorty.domain.interactor.ObservableUseCase
import com.matheusbrandao.rickandmorty.domain.repository.ApiRepository
import io.reactivex.Observable

class FindCharactersUseCase(
    postExecutionThread: PostExecutionThread,
    private val characterRepository: ApiRepository
) : ObservableUseCase<List<Character>, FindCharactersUseCase.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<List<Character>> {
        return characterRepository.findCharacters()
    }

    data class Params(val page: Int, val pageSize: Int)
}