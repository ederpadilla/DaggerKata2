package com.example.daggerglobantsamples.fourthsample.di.component

import com.example.daggerglobantsamples.fourthsample.di.module.SharedPreferencesModule
import com.example.daggerglobantsamples.fourthsample.di.scope.SharedPreferencesScope
import com.example.daggerglobantsamples.fourthsample.ui.four.FourActivity
import com.example.daggerglobantsamples.fourthsample.ui.three.ThreeActivity
import dagger.Subcomponent

@SharedPreferencesScope
@Subcomponent(modules = [SharedPreferencesModule::class])
interface SharedPreferenceSubComponent {

    fun inject(activity : ThreeActivity)

    fun inject(activity: FourActivity)

}