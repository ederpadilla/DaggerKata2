package com.example.daggerglobantsamples.fourthsample.ui.three

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RelativeLayout
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.SampleApp
import com.example.daggerglobantsamples.firstsample.utils.DebugUtils
import com.example.daggerglobantsamples.fourthsample.api.SimpsonClient
import com.example.daggerglobantsamples.fourthsample.model.simpsons.SimpsonResponse
import com.example.daggerglobantsamples.fourthsample.ui.four.FourActivity
import com.example.daggerglobantsamples.fourthsample.ui.two.adapter.SimpsonsAdapter
import kotlinx.android.synthetic.main.activity_three.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ThreeActivity : AppCompatActivity() {

    @Inject
    lateinit var context : Context

    @Inject
    lateinit var apiClient: SimpsonClient

    @Inject
    lateinit var simpsonsAdapter : SimpsonsAdapter

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        (application as SampleApp).plusSharedPrefrenceSubComponent().inject(this)
        setUpRecycler(simpsonsRecycler)
        webServicePetition()
    }

    fun goNext(view : View){
        startActivity(Intent(this,FourActivity::class.java))
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
                                    response: Response<MutableList<SimpsonResponse>>
            ) {
                DebugUtils.showLog(
                    ThreeActivity::class.java.simpleName,
                    "Response ${response.body()}")
                simpsonsAdapter.setData(response.body()!!)
                val editor = sharedPreferences.edit()
                editor.putString(DebugUtils.CHARACTER, response.body()!![0].character)
                editor.putString(DebugUtils.QUOTE, response.body()!![0].quote)
                editor.apply()
            }

        })
    }
}
