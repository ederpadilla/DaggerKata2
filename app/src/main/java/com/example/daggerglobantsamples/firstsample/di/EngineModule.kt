package com.example.daggerglobantsamples.firstsample.di

import com.example.daggerglobantsamples.firstsample.oldschool.Car
import com.example.daggerglobantsamples.firstsample.oldschool.Engine
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class EngineModule {

    @Named("Diesel")
    @Singleton
    @Provides
    fun providesDieselEngine(): Engine {
        return Engine("Diesel")
    }
    @Named("Gas")
    @Provides
    fun provideGasMotor() : Engine {
        return Engine("Gas")
    }
    @Provides
    fun providesCar( @Named("Gas")engine: Engine): Car {
        return Car(engine)
    }



}