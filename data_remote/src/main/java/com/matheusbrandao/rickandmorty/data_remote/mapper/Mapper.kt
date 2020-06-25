package com.matheusbrandao.rickandmorty.data_remote.mapper

interface Mapper<R, M> {
    fun fromRemote(remote: R): M
    fun toRemote(domain: M): R
}
