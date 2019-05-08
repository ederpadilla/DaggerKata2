package com.example.daggerglobantsamples.firstsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.firstsample.oldschool.Car
import com.example.daggerglobantsamples.firstsample.oldschool.Engine
import com.example.daggerglobantsamples.firstsample.utils.DebugUtils
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class EngineOldSchoolActivity : AppCompatActivity() {
    val TAG = EngineOldSchoolActivity::class.java.simpleName

    @Inject
    @field:Named("Diesel")
    lateinit var engine : Engine

    @Inject
    lateinit var car : Car

    @Inject
    lateinit var lazyCar : Lazy<Car>

    @Inject
    lateinit var providerCar : Provider<Car> // New Instance of that object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as SampleApp).engineComponent.inject(this)
        setContentView(R.layout.activity_engine_old_school)
        DebugUtils.showLog(TAG,"Egine $engine")
        DebugUtils.showLog(TAG,"Car $car")

        DebugUtils.showLog(TAG,"Lazy Car ${lazyCar.get()}")
        DebugUtils.showLog(TAG,"Provider Car ${providerCar.get()}")
    }
}
