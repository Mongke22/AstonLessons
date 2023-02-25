package com.example.astonlesson2.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.astonlesson2.models.Vacancy

class VacancyDiffCallBack : DiffUtil.ItemCallback<Vacancy>() {
    override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
        return oldItem == newItem
    }
}