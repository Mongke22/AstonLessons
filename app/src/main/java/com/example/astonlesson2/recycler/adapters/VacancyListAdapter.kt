package com.example.astonlesson2.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.astonlesson2.R
import com.example.astonlesson2.models.Vacancy
import com.example.astonlesson2.recycler.VacancyDiffCallBack
import com.example.astonlesson2.recycler.holders.VacancyViewHolder
import java.text.SimpleDateFormat
import java.util.*

class VacancyListAdapter: ListAdapter<Vacancy, VacancyViewHolder>(VacancyDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val layout = R.layout.vacancy_list_element
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return VacancyViewHolder(view)
    }


    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        val vacancy = getItem(position)
        holder.picture.setImageResource(vacancy.imageSource)
        holder.title.text = vacancy.title
        holder.subtitle.text = vacancy.subTitle
    }


}