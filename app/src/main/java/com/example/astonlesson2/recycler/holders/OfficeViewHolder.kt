package com.example.astonlesson2.recycler.holders

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.astonlesson2.databinding.BelarusianOfficeListElementBinding
import com.example.astonlesson2.databinding.RussianOfficeListElementBinding
import com.example.astonlesson2.models.Office

abstract class OfficeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    abstract fun populate(item: Office, clickListener: ((Office) -> Unit))

}

class BelarusianOfficeViewHolder(private val binding: BelarusianOfficeListElementBinding): OfficeViewHolder(binding.root){
    override fun populate(item: Office, clickListener: ((Office) -> Unit)) {
        binding.officeIcon.setImageResource(item.flag)
        binding.officeName.text = item.city
        binding.root.setOnClickListener{
            clickListener.invoke(item)
        }
    }

}

class RussianOfficeViewHolder(private val binding: RussianOfficeListElementBinding): OfficeViewHolder(binding.root){
    override fun populate(item: Office, clickListener: ((Office) -> Unit)) {
        binding.officeIcon.setImageResource(item.flag)
        binding.officeName.text = item.city
        binding.root.setOnClickListener{
            clickListener.invoke(item)
        }
    }

}