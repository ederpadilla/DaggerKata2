package com.example.daggerglobantsamples.fourthsample.di.component

import com.example.daggerglobantsamples.fourthsample.di.module.AdapterModule
import com.example.daggerglobantsamples.fourthsample.di.module.ApplicationContextModule
import com.example.daggerglobantsamples.fourthsample.di.module.RetrofitModule
import com.example.daggerglobantsamples.fourthsample.di.module.SharedPreferencesModule
import com.example.daggerglobantsamples.fourthsample.di.scope.ApplicationScope
import com.example.daggerglobantsamples.fourthsample.ui.two.TwoActivity
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationContextModule::class,RetrofitModule::class,
                      AdapterModule::class])
interface ApplicationComponent {

    fun plusSharedPreferencesSubComponent (sharedPreferencesModule: SharedPreferencesModule) :
            SharedPreferenceSubComponent

    fun inject(activity : TwoActivity)

}