package com.example.astonlesson2.recycler.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.astonlesson2.databinding.BelarusianOfficeListElementBinding
import com.example.astonlesson2.databinding.RussianOfficeListElementBinding
import com.example.astonlesson2.models.Office

abstract class OfficeViewHolder(view: View): RecyclerView.ViewHolder(view) {
}

class BelarusianOfficeViewHolder(val binding: BelarusianOfficeListElementBinding): OfficeViewHolder(binding.root){

}

class RussianOfficeViewHolder(val binding: RussianOfficeListElementBinding): OfficeViewHolder(binding.root){

}