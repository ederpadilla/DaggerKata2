package com.example.daggerglobantsamples.fourthsample.di.component

import com.example.daggerglobantsamples.fourthsample.di.module.MessageModule
import com.example.daggerglobantsamples.fourthsample.di.scope.MessageScope
import com.example.daggerglobantsamples.fourthsample.ui.one.OneActivity
import dagger.Component

@MessageScope
@Component(modules = [MessageModule::class])
interface MessageComponent {

    fun inject(activity : OneActivity)

}