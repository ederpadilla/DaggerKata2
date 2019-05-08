package com.example.daggerglobantsamples.fourthsample.di.module

import com.example.daggerglobantsamples.fourthsample.di.scope.MessageScope
import com.example.daggerglobantsamples.fourthsample.model.Message
import dagger.Module
import dagger.Provides

@Module
class MessageModule {

    @MessageScope
    @Provides
    fun getMessage() : Message{
        return Message("Time","Number one app")
    }

}