package com.example.daggerglobantsamples.secondsample.di

import com.example.daggerglobantsamples.firstsample.di.PerActivity
import com.example.daggerglobantsamples.secondsample.ui.Main1Activity
import dagger.Component

@PerActivity
@Component(modules = [CarModule::class],dependencies = [EngineSecondComponent::class])
interface CarComponent {

    fun inject(activity : Main1Activity)

}