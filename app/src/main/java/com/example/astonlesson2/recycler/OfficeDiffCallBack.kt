package com.example.astonlesson2.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.astonlesson2.models.Office

class OfficeDiffCallBack : DiffUtil.ItemCallback<Office>() {
    override fun areItemsTheSame(oldItem: Office, newItem: Office): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Office, newItem: Office): Boolean {
        return oldItem == newItem
    }
}