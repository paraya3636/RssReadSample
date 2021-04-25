package com.example.rssreadsample.data.mapper

interface Mapper<in In, out Out> {

    fun map(source: In): Out

    fun map(sources: List<In>): List<Out> {
        return sources.map { map(it) }
    }
}
