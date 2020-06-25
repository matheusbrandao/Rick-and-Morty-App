package com.matheusbrandao.rickandmorty.data.api

import com.matheusbrandao.rickandmorty.domain.Character
import com.matheusbrandao.rickandmorty.domain.CharacterData
import com.matheusbrandao.rickandmorty.domain.Episode
import com.matheusbrandao.rickandmorty.domain.Location
import com.matheusbrandao.rickandmorty.domain.repository.ApiRepository
import io.reactivex.Observable

class ApiRepositoryImpl(
    private val characterRemoteDataSource: ApiRemoteDataSource
) : ApiRepository {

    override fun findCharacters(): Observable<List<Character>> {
        return characterRemoteDataSource.findCharacters()
    }

    override fun findCharacters(page: Int, pageSize: Int): Observable<CharacterData> {
        return characterRemoteDataSource.findCharacters(page, pageSize)
    }

    override fun findLocations(): Observable<List<Location>> {
        return characterRemoteDataSource.findLocations()
    }

    override fun findEpisodes(): Observable<List<Episode>> {
        return characterRemoteDataSource.findEpisodes()
    }
}