package com.example.daggerglobantsamples

import android.app.Application
import com.example.daggerglobantsamples.firstsample.di.DaggerEngineComponent
import com.example.daggerglobantsamples.firstsample.di.EngineComponent
import com.example.daggerglobantsamples.fourthsample.di.component.*
import com.example.daggerglobantsamples.fourthsample.di.module.ApplicationContextModule
import com.example.daggerglobantsamples.fourthsample.di.module.MessageModule
import com.example.daggerglobantsamples.fourthsample.di.module.SharedPreferencesModule
import com.example.daggerglobantsamples.secondsample.di.*
import com.example.daggerglobantsamples.thirdsample.di.AppComponent
import com.example.daggerglobantsamples.thirdsample.di.AppModule
import com.example.daggerglobantsamples.thirdsample.di.DaggerAppComponent

class SampleApp : Application() {

    lateinit var engineComponent : EngineComponent

    lateinit var engine2Component : EngineSecondComponent

    lateinit var carComponent : CarComponent

    lateinit var carSubComponent: CarSubComponent

    lateinit var appComponent : AppComponent

    var messageComponent : MessageComponent ?= null

    var applicationComponent : ApplicationComponent?=null

    lateinit var sharedPreferenceSubComponent: SharedPreferenceSubComponent

    override fun onCreate() {
        super.onCreate()
        engineComponent = DaggerEngineComponent
            .builder()
            .build()
        engine2Component = DaggerEngineSecondComponent
            .builder()
            .build()
        carComponent = DaggerCarComponent
            .builder()
            .engineSecondComponent(engine2Component)
            .build()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        setUpGraphMessageComponent()

        messageComponent = DaggerMessageComponent
            .builder()
            .build()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun plusSharedPrefrenceSubComponent() : SharedPreferenceSubComponent{
        sharedPreferenceSubComponent = applicationComponent!!
            .plusSharedPreferencesSubComponent(SharedPreferencesModule())
        return sharedPreferenceSubComponent
    }

    fun plusCarSuComponent() : CarSubComponent{
        carSubComponent = engine2Component.plusComponent(CarModule())
        return carSubComponent
    }

    fun clearMessageComponent(){
        messageComponent = null
    }

    fun clearApplicationComponent(){
        applicationComponent = null
    }

    fun setUpGraphMessageComponent(){
        messageComponent = DaggerMessageComponent
            .builder()
            .messageModule(MessageModule())
            .build()
    }

}