package com.matheusbrandao.rickandmorty.data_remote.mapper

import com.matheusbrandao.rickandmorty.data_remote.model.LocationEntity
import com.matheusbrandao.rickandmorty.domain.Location

object LocationMapper : Mapper<LocationEntity, Location> {

    override fun fromRemote(remote: LocationEntity): Location {
        return Location(
            name = remote.name,
            type = remote.type
        )
    }

    override fun toRemote(domain: Location): LocationEntity {
        TODO("Not yet implemented")
    }
}