package com.example.daggerglobantsamples.fourthsample.ui.one

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.fourthsample.model.Message
import com.example.daggerglobantsamples.fourthsample.ui.two.TwoActivity
import kotlinx.android.synthetic.main.activity_one.*
import javax.inject.Inject

class OneActivity : AppCompatActivity() {

    @Inject
    lateinit var message: Message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        setUpDagger()
        mTvTitle.text = message.messageTitle
        mTvDes.text = message.messageDes
    }

    private fun setUpDagger() {
        (application as SampleApp).messageComponent?.inject(this)
    }

    fun goToNextActivity(view : View){
        startActivity(Intent(applicationContext,TwoActivity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        (application as SampleApp).clearMessageComponent()
    }
}
