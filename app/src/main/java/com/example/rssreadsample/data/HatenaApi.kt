package com.example.rssreadsample.data

import com.example.rssreadsample.data.response.HatenaXmlResponse
import retrofit2.Call
import retrofit2.http.GET

interface HatenaApi {
    @GET("/hotentry.rss")
    fun GetHotentries(): Call<HatenaXmlResponse>
}