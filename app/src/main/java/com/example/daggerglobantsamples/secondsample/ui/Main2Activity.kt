package com.example.daggerglobantsamples.secondsample.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.firstsample.oldschool.Engine
import com.example.daggerglobantsamples.firstsample.utils.DebugUtils
import javax.inject.Inject

class Main2Activity : AppCompatActivity() {

    @Inject lateinit var engine: Engine

    val TAG = Main2Activity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        (application as SampleApp).engine2Component.inject(this)
        DebugUtils.showLog(TAG,"engine $engine")
    }
}
