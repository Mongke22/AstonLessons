package com.example.astonlesson2.recycler.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.astonlesson2.databinding.HomePageFirstPartBinding
import com.example.astonlesson2.databinding.HomePageSecondPartBinding
import com.example.astonlesson2.databinding.HomePageThirdPartBinding

abstract class MainPageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun populate()
}

class FirstPartHolder(binding: HomePageFirstPartBinding): MainPageHolder(binding.root){
    override fun populate() {

    }
}
class SecondPartHolder(binding: HomePageSecondPartBinding): MainPageHolder(binding.root){
    override fun populate() {

    }
}
class ThirdPartHolder(binding: HomePageThirdPartBinding): MainPageHolder(binding.root){
    override fun populate() {

    }
}