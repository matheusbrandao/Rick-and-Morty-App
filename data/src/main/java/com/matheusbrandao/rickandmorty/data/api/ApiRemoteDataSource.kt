package com.matheusbrandao.rickandmorty.data.api

import com.matheusbrandao.rickandmorty.domain.Character
import com.matheusbrandao.rickandmorty.domain.CharacterData
import com.matheusbrandao.rickandmorty.domain.Episode
import com.matheusbrandao.rickandmorty.domain.Location
import io.reactivex.Observable

interface ApiRemoteDataSource {

    fun findCharacters(): Observable<List<Character>>
    fun findCharacters(page: Int): Observable<List<Character>>
    fun findLocations(): Observable<List<Location>>
    fun findEpisodes(): Observable<List<Episode>>
}