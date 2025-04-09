package com.luizvicari.moodtracker.data.model

sealed class AuthState{

    data class Success(val user: User): AuthState()
    data class Error(val message: String): AuthState()
    object Loading: AuthState()
}

