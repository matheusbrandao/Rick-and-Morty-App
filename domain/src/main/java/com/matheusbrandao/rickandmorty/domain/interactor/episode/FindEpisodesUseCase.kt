package com.matheusbrandao.rickandmorty.domain.interactor.episode

import com.matheusbrandao.rickandmorty.domain.Episode
import com.matheusbrandao.rickandmorty.domain.executor.PostExecutionThread
import com.matheusbrandao.rickandmorty.domain.interactor.ObservableUseCase
import com.matheusbrandao.rickandmorty.domain.repository.ApiRepository
import io.reactivex.Observable

class FindEpisodesUseCase(
    postExecutionThread: PostExecutionThread,
    private val characterRepository: ApiRepository
) : ObservableUseCase<List<Episode>, Unit>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit?): Observable<List<Episode>> {
        return characterRepository.findEpisodes()
    }
}