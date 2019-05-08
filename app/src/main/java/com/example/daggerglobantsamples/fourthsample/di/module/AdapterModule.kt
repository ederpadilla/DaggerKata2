package com.example.daggerglobantsamples.fourthsample.di.module

import android.widget.SimpleAdapter
import com.example.daggerglobantsamples.fourthsample.ui.two.adapter.SimpsonsAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun providesSimpsonsAdapter() : SimpsonsAdapter {
        return SimpsonsAdapter()
    }
}