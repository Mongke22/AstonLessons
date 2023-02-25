package com.example.astonlesson2.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astonlesson2.R
import com.example.astonlesson2.databinding.HomePageFirstPartBinding
import com.example.astonlesson2.databinding.HomePageSecondPartBinding
import com.example.astonlesson2.databinding.HomePageThirdPartBinding
import com.example.astonlesson2.databinding.RussianOfficeListElementBinding
import com.example.astonlesson2.models.MainPageModel
import com.example.astonlesson2.recycler.holders.*

class MainPageAdapter(private val layouts: List<MainPageModel>): RecyclerView.Adapter<MainPageHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageHolder {
       return when(viewType){
           R.layout.home_page_first_part -> {
               FirstPartHolder(
                   HomePageFirstPartBinding.inflate(
                   LayoutInflater.from(parent.context), parent, false)
               )
           }
           R.layout.home_page_second_part -> {
               SecondPartHolder(
                   HomePageSecondPartBinding.inflate(
                       LayoutInflater.from(parent.context), parent, false)
               )
           }
           else -> {
               ThirdPartHolder(
                   HomePageThirdPartBinding.inflate(
                       LayoutInflater.from(parent.context), parent, false)
               )
           }
       }
    }

    override fun onBindViewHolder(holder: MainPageHolder, position: Int) {
        holder.populate()
    }

    override fun getItemViewType(position: Int): Int {
        return layouts[position].type
    }

    override fun getItemCount(): Int {
        return layouts.size
    }
}