package com.example.daggerglobantsamples.thirdsample.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.thirdsample.ui.login.presenter.LoginPresenter
import com.example.daggerglobantsamples.thirdsample.ui.login.view.LoginView
import com.example.daggerglobantsamples.thirdsample.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginView.View {

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        (application as SampleApp).appComponent.inject(this)
        loginPresenter.setView(this)
    }

    fun loginClick(view : View){
        loginPresenter.validateUser(mEtName.text.toString(),mEtAge.text.toString())
    }

    override fun validUser() {
        startActivity(Intent(this,ProfileActivity::class.java))
        finish()
    }

    override fun invalidUser() {
        Toast.makeText(this,R.string.invalid_user,Toast.LENGTH_SHORT).show()
    }


}
