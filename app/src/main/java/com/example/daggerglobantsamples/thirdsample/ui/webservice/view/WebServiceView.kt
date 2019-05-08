package com.example.daggerglobantsamples.thirdsample.ui.webservice.view

import com.example.daggerglobantsamples.thirdsample.model.User

interface WebServiceView {

    interface View{
        fun showUser(user: User)
    }

    interface Presenter{
        fun setView(view : WebServiceView.View)
        fun getPeopleRequest()
    }
}