package com.example.daggerglobantsamples.fourthsample.ui.two.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daggerglobantsamples.R
import com.example.daggerglobantsamples.fourthsample.model.simpsons.SimpsonResponse

class SimpsonsAdapter() : RecyclerView.Adapter<SimpsonsAdapter.SimpsonViwHolder>() {

    private var simpsons = mutableListOf<SimpsonResponse>()

    fun setData(simpsons : MutableList<SimpsonResponse>){
        this.simpsons.addAll(simpsons)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): SimpsonViwHolder {
        return SimpsonViwHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.simpson_item,
            viewGroup,false))
    }

    override fun getItemCount(): Int {
        return simpsons.size
    }

    override fun onBindViewHolder(viewHolder: SimpsonViwHolder, pos: Int) {
        val simpson = simpsons[pos]
        viewHolder.setUpSimpson(simpson)
    }

    inner class SimpsonViwHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mImgChar: ImageView = itemView.findViewById(R.id.mImgChar)
        private val mTvCharacter: TextView = itemView.findViewById(R.id.mTvCharacter)
        private val mTvQuote: TextView = itemView.findViewById(R.id.mTvQuote)

        fun setUpSimpson(simpson : SimpsonResponse){
            Glide.with(mImgChar).load(simpson.image)
                .apply(RequestOptions().fitCenter())
                .into(mImgChar)
            mTvCharacter.text = simpson.character
            mTvQuote.text = simpson.quote
        }
    }

}