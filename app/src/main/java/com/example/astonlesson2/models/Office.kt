package com.example.astonlesson2.models

import java.io.Serializable

data class Office(
    val id: Int,
    val type: Int,
    val flag: Int,
    val country: String,
    val city: String,
    val location: String
): Serializable
