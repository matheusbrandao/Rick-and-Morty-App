package com.matheusbrandao.rickandmorty.domain.repository

import com.matheusbrandao.rickandmorty.domain.Character
import com.matheusbrandao.rickandmorty.domain.CharacterData
import com.matheusbrandao.rickandmorty.domain.Episode
import com.matheusbrandao.rickandmorty.domain.Location
import io.reactivex.Observable

interface ApiRepository {

    fun findCharacters(): Observable<List<Character>>
    fun findCharacters(page: Int, pageSize: Int): Observable<CharacterData>
    fun findLocations(): Observable<List<Location>>
    fun findEpisodes(): Observable<List<Episode>>
}