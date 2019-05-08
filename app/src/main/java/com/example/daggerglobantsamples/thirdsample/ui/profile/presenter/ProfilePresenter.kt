package com.example.daggerglobantsamples.thirdsample.ui.profile.presenter

import com.example.daggerglobantsamples.thirdsample.model.User
import com.example.daggerglobantsamples.thirdsample.ui.profile.view.ProfileView

class ProfilePresenter(private val user: User) : ProfileView.Presenter {

    private lateinit var view : ProfileView.View

    override fun setView(view: ProfileView.View) {
        this.view = view
        view.showUser(user)
    }

    override fun updateUser(updatedUser : User) {
        user.userName = updatedUser.userName
        user.age = updatedUser.age
    }

    override fun logOut() {
        user.userName = ""
        user.age = ""
        view.logOut()
    }

}