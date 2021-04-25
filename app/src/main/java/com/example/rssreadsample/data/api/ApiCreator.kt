package com.example.rssreadsample.data.api

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class ApiCreator {
    fun <T> create(clazz: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://b.hatena.ne.jp")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        
        return retrofit.create(clazz)
    }
}