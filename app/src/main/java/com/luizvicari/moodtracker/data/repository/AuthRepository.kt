package com.luizvicari.moodtracker.data.repository

import com.luizvicari.moodtracker.data.model.AuthState
import com.luizvicari.moodtracker.data.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser: Flow<User?>

    suspend fun signIn(email: String, password: String): AuthState
    suspend fun signUp(email: String, password: String, displayName: String): AuthState
    suspend fun signOut()
    fun isAuthenticated(): Boolean
}