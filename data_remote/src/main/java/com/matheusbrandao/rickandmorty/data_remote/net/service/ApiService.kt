package com.matheusbrandao.rickandmorty.data_remote.net.service

import com.matheusbrandao.rickandmorty.data_remote.model.CharacterDataEntity
import com.matheusbrandao.rickandmorty.data_remote.model.EpisodeDataEntity
import com.matheusbrandao.rickandmorty.data_remote.model.LocationDataEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("/api/character/")
    fun findCharacters(): Observable<CharacterDataEntity>

    @GET("/api/character/")
    fun findCharacters(@Query("page") page: Int): Observable<CharacterDataEntity>

    @GET("/api/location")
    fun findLocations(): Observable<LocationDataEntity>

    @GET("/api/episode")
    fun findEpisodes(): Observable<EpisodeDataEntity>

}