package com.example.daggerglobantsamples.secondsample.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.firstsample.oldschool.Car
import com.example.daggerglobantsamples.firstsample.utils.DebugUtils
import javax.inject.Inject
import javax.inject.Named

class Main3Activity : AppCompatActivity() {

    @Inject
    @field:Named("gas_car")
    lateinit var gasCar : Car

    val TAG = Main3Activity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        (application as SampleApp).plusCarSuComponent().inject(this)
        DebugUtils.showLog(TAG,"gasCAr $gasCar")

    }
}
