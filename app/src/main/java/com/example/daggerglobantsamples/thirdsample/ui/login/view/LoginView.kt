package com.example.daggerglobantsamples.thirdsample.ui.login.view

interface LoginView {

    interface View{
        fun validUser()
        fun invalidUser()
    }

    interface Presenter{
        fun setView(view : LoginView.View)
        fun validateUser(mail : String, password : String)
    }
}