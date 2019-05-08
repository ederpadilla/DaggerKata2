package com.example.daggerglobantsamples.thirdsample.api

import com.example.daggerglobantsamples.thirdsample.modelresponse.StarWarsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {

    @GET("people")
    fun getPeople() : Call<StarWarsResponse>

}