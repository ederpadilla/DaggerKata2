package com.example.daggerglobantsamples.fourthsample.di.module

import android.app.Application
import android.content.Context
import com.example.daggerglobantsamples.fourthsample.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationContextModule(private val application: Application) {

    @Provides
    @ApplicationScope
    fun providesApplication() : Application{
        return application
    }

    @Provides
    @ApplicationScope
    fun providesContext() : Context{
        return application.applicationContext
    }



}