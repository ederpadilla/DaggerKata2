package com.example.daggerglobantsamples.secondsample.di

import com.example.daggerglobantsamples.firstsample.oldschool.Engine
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class EngineSecondModule {

    @Provides
    fun providesDieselEngine() : Engine{
        return Engine("Diesel")
    }

    @Provides
    @Named("Electric")
    fun providesElectricEngine() : Engine{
        return Engine("Electric")
    }

    @Provides
    @Named("Gas")
    fun providesGasEngine() : Engine{
        return Engine("Gas")
    }
}