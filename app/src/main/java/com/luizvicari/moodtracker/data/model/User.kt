package com.luizvicari.moodtracker.data.model

data class User(
    val id: String,
    val email: String,
    val displayName: String,
    val photoUrl: String? = null
)
