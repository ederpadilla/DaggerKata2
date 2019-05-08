package com.example.daggerglobantsamples.secondsample.di

import com.example.daggerglobantsamples.firstsample.oldschool.Car
import com.example.daggerglobantsamples.firstsample.oldschool.Engine
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CarModule {

    @Provides
    fun providesDieselCar(engine : Engine) : Car{
        return Car(engine)
    }

    @Named("electric_car")
    @Provides
    fun providesElectricCar(@Named("Electric")engine : Engine) : Car{
        return Car(engine)
    }

    @Named("gas_car")
    @Provides
    fun providesGasCar(    @Named("Gas")engine : Engine) : Car{
        return Car(engine)
    }

}