package br.com.caio.forum.mapper

interface Mapper<T, U> {

    fun map(t: T):U
}