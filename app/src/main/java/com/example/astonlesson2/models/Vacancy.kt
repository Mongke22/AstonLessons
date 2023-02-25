package com.example.astonlesson2.models

import android.net.Uri
import java.io.Serializable

data class Vacancy(
    val id: Int,
    var imageSource: Int,
    var title: String,
    var subTitle: String
): Serializable
