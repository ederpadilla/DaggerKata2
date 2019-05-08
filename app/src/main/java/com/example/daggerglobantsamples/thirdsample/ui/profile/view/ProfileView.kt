package com.example.daggerglobantsamples.thirdsample.ui.profile.view

import com.example.daggerglobantsamples.thirdsample.model.User

interface ProfileView {

    interface View{
        fun showUser(user : User)
        fun logOut()
    }

    interface Presenter{
        fun setView(view: ProfileView.View)
        fun updateUser(user : User)
        fun logOut()
    }
}