package com.example.daggerglobantsamples.secondsample.di

import com.example.daggerglobantsamples.firstsample.oldschool.Engine
import com.example.daggerglobantsamples.secondsample.ui.Main2Activity
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [EngineSecondModule::class])
interface EngineSecondComponent {

    fun engine() : Engine
    @Named("Electric") fun electricEngine(): Engine
    @Named("Gas") fun gasEngine(): Engine
    fun inject(activity : Main2Activity)

    fun plusComponent(carModule: CarModule) : CarSubComponent
}