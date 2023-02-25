package com.example.astonlesson2.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.astonlesson2.R
import com.example.astonlesson2.databinding.BelarusianOfficeListElementBinding
import com.example.astonlesson2.databinding.RussianOfficeListElementBinding
import com.example.astonlesson2.models.Office
import com.example.astonlesson2.recycler.OfficeDiffCallBack
import com.example.astonlesson2.recycler.holders.BelarusianOfficeViewHolder
import com.example.astonlesson2.recycler.holders.OfficeViewHolder
import com.example.astonlesson2.recycler.holders.RussianOfficeViewHolder

class OfficeListAdapter: ListAdapter<Office, OfficeViewHolder>(OfficeDiffCallBack())  {

    var onClickFunction: ((Office) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficeViewHolder {
        return when(viewType){
            R.layout.russian_office_list_element -> {
                RussianOfficeViewHolder(RussianOfficeListElementBinding.inflate(LayoutInflater.from(parent.context)))
            }
            else -> {
                BelarusianOfficeViewHolder(BelarusianOfficeListElementBinding.inflate(LayoutInflater.from(parent.context)))
            }
        }
    }

    override fun onBindViewHolder(holder: OfficeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }
}