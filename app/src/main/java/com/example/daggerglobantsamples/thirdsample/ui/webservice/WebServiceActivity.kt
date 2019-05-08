package com.example.daggerglobantsamples.thirdsample.ui.webservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.thirdsample.model.User
import com.example.daggerglobantsamples.thirdsample.ui.webservice.presenter.WebServicePresenter
import com.example.daggerglobantsamples.thirdsample.ui.webservice.view.WebServiceView
import kotlinx.android.synthetic.main.activity_web_service.*
import javax.inject.Inject

class WebServiceActivity : AppCompatActivity(), WebServiceView.View {


    @Inject
    lateinit var webServicePresenter: WebServicePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)
        (application as SampleApp).appComponent.inject(this)
        webServicePresenter.setView(this)
    }

    override fun showUser(user: User) {
        mEtName.setText(user.userName)
        mEtAge.setText(user.age)
    }
    fun goBackProfile(view: View){
        finish()
    }

    fun callWs(view: View){
        webServicePresenter.getPeopleRequest()
    }

}
