package com.luizvicari.moodtracker.di

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.luizvicari.moodtracker.data.repository.AuthRepository
import com.luizvicari.moodtracker.data.repository.FirebaseAuthRepository
import org.koin.dsl.module

val authModule = module {
    single {Firebase.auth}
    single<AuthRepository> { FirebaseAuthRepository(get()) }
}