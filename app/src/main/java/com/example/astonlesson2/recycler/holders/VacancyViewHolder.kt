package com.example.astonlesson2.recycler.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.astonlesson2.R

class VacancyViewHolder(view: View): RecyclerView.ViewHolder(view)   {
    var picture: ImageView
    var title: TextView
    var subtitle: TextView
    init{
        picture = view.findViewById(R.id.logo)
        title = view.findViewById(R.id.mainText)
        subtitle = view.findViewById(R.id.subText)
    }
}