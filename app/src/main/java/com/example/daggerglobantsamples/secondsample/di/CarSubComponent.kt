package com.example.daggerglobantsamples.secondsample.di

import com.example.daggerglobantsamples.secondsample.ui.Main3Activity
import dagger.Subcomponent

@Subcomponent(modules = [CarModule::class])
interface CarSubComponent {

    fun inject(activity : Main3Activity)

}