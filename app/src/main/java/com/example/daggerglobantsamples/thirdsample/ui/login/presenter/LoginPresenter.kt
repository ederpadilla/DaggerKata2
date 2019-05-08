package com.example.daggerglobantsamples.thirdsample.ui.login.presenter

import com.example.daggerglobantsamples.thirdsample.model.User
import com.example.daggerglobantsamples.thirdsample.ui.login.view.LoginView

class LoginPresenter(private val user : User) : LoginView.Presenter {

    private lateinit var loginView : LoginView.View

    override fun setView(view: LoginView.View) {
        this.loginView = view
    }

    override fun validateUser(mail: String, password: String) {
        if (mail.isNotEmpty()&&password.isNotEmpty()){
            if (mail=="eder"&& password=="123"){
                loginView.validUser()
                user.userName = mail
                user.age = "24"
            }else{
                loginView.invalidUser()
            }
        }
    }

}