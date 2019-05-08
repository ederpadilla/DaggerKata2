package com.example.daggerglobantsamples.fourthsample.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.daggerglobantsamples.fourthsample.di.scope.SharedPreferencesScope
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule {

    public val SHARED_PREF = "shared_pref"

    @Provides
    @SharedPreferencesScope
    fun providesSharedPreferences(context : Context) : SharedPreferences{
        return context.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE)
    }

}