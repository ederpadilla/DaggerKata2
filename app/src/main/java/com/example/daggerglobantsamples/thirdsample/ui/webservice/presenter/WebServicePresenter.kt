package com.example.daggerglobantsamples.thirdsample.ui.webservice.presenter

import com.example.daggerglobantsamples.firstsample.utils.DebugUtils
import com.example.daggerglobantsamples.thirdsample.api.ApiClient
import com.example.daggerglobantsamples.thirdsample.model.User
import com.example.daggerglobantsamples.thirdsample.modelresponse.StarWarsResponse
import com.example.daggerglobantsamples.thirdsample.ui.webservice.view.WebServiceView


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebServicePresenter(private val user: User, private val apiClient: ApiClient)
    : WebServiceView.Presenter {

    lateinit var webServiceView: WebServiceView.View

    override fun setView(view: WebServiceView.View) {
        this.webServiceView = view
        view.showUser(user)
    }

    override fun getPeopleRequest() {
        val call = apiClient.getPeople()
        call.enqueue(object : Callback<StarWarsResponse> {
            override fun onResponse(call: Call<StarWarsResponse>, response: Response<StarWarsResponse>) {
                DebugUtils.showLog(WebServicePresenter::class.java.simpleName,
                    "Response ${response.body()}")
            }
            override fun onFailure(call: Call<StarWarsResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}