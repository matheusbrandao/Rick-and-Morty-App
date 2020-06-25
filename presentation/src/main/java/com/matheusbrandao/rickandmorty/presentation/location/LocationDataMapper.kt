package com.matheusbrandao.rickandmorty.presentation.location

import com.matheusbrandao.rickandmorty.domain.Location
import com.matheusbrandao.rickandmorty.presentation.Mapper

object LocationDataMapper :
    Mapper<Location, LocationBinding> {

    override fun fromDomain(domain: Location): LocationBinding {
        return LocationBinding(
            nome = domain.name,
            type = domain.type
        )
    }
}