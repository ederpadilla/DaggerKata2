package com.example.daggerglobantsamples.fourthsample.ui.four

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.firstsample.utils.DebugUtils
import kotlinx.android.synthetic.main.activity_four.*
import javax.inject.Inject

class FourActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)
        (application as SampleApp).plusSharedPrefrenceSubComponent().inject(this)
        read()
    }

    private fun read(){
        mTvCharacter.text = sharedPreferences.getString(DebugUtils.CHARACTER,":(")
        mTvQuote.text = sharedPreferences.getString(DebugUtils.QUOTE,":(")
    }
}
