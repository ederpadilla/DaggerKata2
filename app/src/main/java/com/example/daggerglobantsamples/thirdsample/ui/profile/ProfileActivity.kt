package com.example.daggerglobantsamples.thirdsample.ui.profile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.thirdsample.model.User
import com.example.daggerglobantsamples.thirdsample.ui.login.LoginActivity
import com.example.daggerglobantsamples.thirdsample.ui.webservice.WebServiceActivity
import com.example.daggerglobantsamples.thirdsample.ui.profile.presenter.ProfilePresenter
import com.example.daggerglobantsamples.thirdsample.ui.profile.view.ProfileView
import kotlinx.android.synthetic.main.activity_profile.*
import javax.inject.Inject



class ProfileActivity : AppCompatActivity(),ProfileView.View {

    @Inject
    lateinit var profilePresenter : ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        (application as SampleApp).appComponent.inject(this)
        profilePresenter.setView(this)
    }

    override fun showUser(user: User) {
        mEtName.setText(user.userName)
        mEtAge.setText(user.age)
    }

    fun updateClick(view: View){
        val updatedUser = User()
        updatedUser.userName = mEtName.text.toString()
        updatedUser.age = mEtAge.text.toString()
        profilePresenter.updateUser(updatedUser)
    }

    fun logOutClick(view : View){
        profilePresenter.logOut()
    }

    fun nextActivity(view : View){
        startActivity(Intent(this, WebServiceActivity::class.java))
    }

    override fun logOut() {
        val intent = Intent(this,LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
