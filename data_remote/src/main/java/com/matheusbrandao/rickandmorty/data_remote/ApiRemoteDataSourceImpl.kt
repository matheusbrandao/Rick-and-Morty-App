package com.matheusbrandao.rickandmorty.data_remote

import com.matheusbrandao.rickandmorty.data.api.ApiRemoteDataSource
import com.matheusbrandao.rickandmorty.data_remote.mapper.CharacterDataMapper
import com.matheusbrandao.rickandmorty.data_remote.mapper.CharacterMapper
import com.matheusbrandao.rickandmorty.data_remote.mapper.EpisodeMapper
import com.matheusbrandao.rickandmorty.data_remote.mapper.LocationMapper
import com.matheusbrandao.rickandmorty.data_remote.net.service.ApiService
import com.matheusbrandao.rickandmorty.domain.Character
import com.matheusbrandao.rickandmorty.domain.CharacterData
import com.matheusbrandao.rickandmorty.domain.Episode
import com.matheusbrandao.rickandmorty.domain.Location
import io.reactivex.Observable

class ApiRemoteDataSourceImpl(private val characterService: ApiService) :
    ApiRemoteDataSource {

    override fun findCharacters(): Observable<List<Character>> {
        return characterService.findCharacters()
            .map {
                it.results.map(
                    CharacterMapper::fromRemote
                )
            }
    }

    override fun findCharacters(page: Int, pageSize: Int): Observable<CharacterData> {
        return characterService.findCharacters(page).map {
            CharacterDataMapper.fromRemote(it)
        }
    }

    override fun findLocations(): Observable<List<Location>> {
        return characterService.findLocations()
            .map {
                it.results.map(
                    LocationMapper::fromRemote
                )
            }
    }

    override fun findEpisodes(): Observable<List<Episode>> {
        return characterService.findEpisodes()
            .map {
                it.results.map(
                    EpisodeMapper::fromRemote
                )
            }
    }
}