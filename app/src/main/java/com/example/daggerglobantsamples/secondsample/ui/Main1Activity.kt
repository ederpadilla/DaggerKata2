package com.example.daggerglobantsamples.secondsample.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.firstsample.oldschool.Car
import com.example.daggerglobantsamples.firstsample.utils.DebugUtils
import javax.inject.Inject
import javax.inject.Named

class Main1Activity : AppCompatActivity() {


    @Inject  lateinit var car : Car


    @field:Named("electric_car")
    @Inject
    lateinit var electricCar : Car

    @field:Named("gas_car")
    @Inject
    lateinit var gasCar : Car

    val TAG = Main1Activity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        (application as SampleApp).carComponent.inject(this)
        DebugUtils.showLog(TAG,"Enine injected1 is $car")
        DebugUtils.showLog(TAG,"Enine injected2 is $electricCar")
        DebugUtils.showLog(TAG,"Enine injected3 is $gasCar")
    }

    fun goToSecondActivityClick(view : View){
        startActivity(Intent(this,Main2Activity::class.java))

    }

    fun goToSSubViewActivityClick(view : View){
        startActivity(Intent(this,Main3Activity::class.java))

    }
}
