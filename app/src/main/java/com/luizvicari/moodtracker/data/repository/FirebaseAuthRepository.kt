package com.luizvicari.moodtracker.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.luizvicari.moodtracker.data.model.AuthState
import com.luizvicari.moodtracker.data.model.User
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository (private val auth: FirebaseAuth) :  AuthRepository {
    private val _currentUser = MutableStateFlow<User?>(null)
    override val currentUser: Flow<User?> = _currentUser

    override suspend fun signIn(email: String, password: String): AuthState {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(email: String, password: String, displayName: String): AuthState {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            result.user?.let { firebaseUser ->
                val profileUpdates = UserProfileChangeRequest.Builder().setDisplayName(displayName).build()
                firebaseUser.updateProfile(profileUpdates).await()

                val user = User(id = firebaseUser.uid, email = firebaseUser.email ?: "", displayName = displayName)
                _currentUser.value = user
                AuthState.Success(user)
            } ?: AuthState.Error("Failed to create user")
        } catch (e: Exception) {
            AuthState.Error(e.message?: "Registration failed")

        }
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }

    override fun isAuthenticated(): Boolean {
        TODO("Not yet implemented")
    }
}