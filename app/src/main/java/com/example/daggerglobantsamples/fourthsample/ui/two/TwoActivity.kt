package com.example.daggerglobantsamples.fourthsample.ui.two

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.firstsample.utils.DebugUtils
import com.example.daggerglobantsamples.fourthsample.api.SimpsonClient
import com.example.daggerglobantsamples.fourthsample.model.simpsons.SimpsonResponse
import com.example.daggerglobantsamples.fourthsample.ui.three.ThreeActivity
import com.example.daggerglobantsamples.fourthsample.ui.two.adapter.SimpsonsAdapter
import com.example.daggerglobantsamples.thirdsample.api.ApiClient
import com.example.daggerglobantsamples.thirdsample.ui.webservice.presenter.WebServicePresenter
import kotlinx.android.synthetic.main.activity_two.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TwoActivity : AppCompatActivity() {

    @Inject
    lateinit var context : Context

    @Inject
    lateinit var apiClient: SimpsonClient

    @Inject
    lateinit var simpsonsAdapter : SimpsonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        (application as SampleApp).applicationComponent?.inject(this)
        setUpRecycler(simpsonsRecycler)
        webServicePetition()
    }

    private fun setUpRecycler(simpsonsRecycler: RecyclerView) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        simpsonsRecycler.layoutManager = layoutManager
        simpsonsRecycler.adapter = simpsonsAdapter
    }

    private fun webServicePetition() {
        val call = apiClient.getSimpsonQuote(1)
        call.enqueue(object : Callback<MutableList<SimpsonResponse>> {
            override fun onFailure(call: Call<MutableList<SimpsonResponse>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MutableList<SimpsonResponse>>,
                                    response: Response<MutableList<SimpsonResponse>>) {
                DebugUtils.showLog(
                    TwoActivity::class.java.simpleName,
                    "Response ${response.body()}")
                simpsonsAdapter.setData(response.body()!!)
            }

        })
    }

    fun nextActivity(view: View){
        startActivity(Intent(this,ThreeActivity::class.java))
    }

}
