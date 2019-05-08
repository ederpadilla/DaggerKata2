package com.example.daggerglobantsamples.fourthsample.api

import com.example.daggerglobantsamples.fourthsample.model.simpsons.SimpsonResponse
import com.example.daggerglobantsamples.thirdsample.modelresponse.StarWarsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonClient {

    @GET("quotes")
    fun getSimpsonQuote(@Query("count") quote : Int) : Call<MutableList<SimpsonResponse>>

}