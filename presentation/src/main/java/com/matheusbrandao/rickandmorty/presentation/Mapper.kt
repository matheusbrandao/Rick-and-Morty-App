package com.matheusbrandao.rickandmorty.presentation

interface Mapper<D, P> {
    fun fromDomain(domain: D): P
}
