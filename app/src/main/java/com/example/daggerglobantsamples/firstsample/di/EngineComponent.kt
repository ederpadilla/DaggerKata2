package com.example.daggerglobantsamples.firstsample.di

import com.example.daggerglobantsamples.firstsample.EngineOldSchoolActivity
import dagger.Component
import javax.inject.Singleton

@PerActivity
@Singleton
@Component(modules = [EngineModule::class])
interface EngineComponent {

    fun inject(engineActivity : EngineOldSchoolActivity)

}