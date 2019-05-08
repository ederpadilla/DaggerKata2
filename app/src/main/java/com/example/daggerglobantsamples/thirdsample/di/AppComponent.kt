package com.example.daggerglobantsamples.thirdsample.di

import com.example.daggerglobantsamples.thirdsample.ui.login.LoginActivity
import com.example.daggerglobantsamples.thirdsample.ui.profile.ProfileActivity
import com.example.daggerglobantsamples.thirdsample.ui.webservice.WebServiceActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity : LoginActivity)
    fun inject(activity : ProfileActivity)
    fun inject(activity: WebServiceActivity)
}