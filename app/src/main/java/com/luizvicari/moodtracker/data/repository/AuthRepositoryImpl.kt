package com.luizvicari.moodtracker.data.repository

import com.luizvicari.moodtracker.data.model.AuthState
import com.luizvicari.moodtracker.data.model.User
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl :  AuthRepository {
    override val currentUser: Flow<User?>
        get() = TODO("Not yet implemented")

    override suspend fun signIn(email: String, password: String): AuthState {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(email: String, password: String, displayName: String): AuthState {
        TODO("Not yet implemented")
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }

    override fun isAuthenticated(): Boolean {
        TODO("Not yet implemented")
    }
}