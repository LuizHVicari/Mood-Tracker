package com.luizvicari.moodtracker.di

import com.luizvicari.moodtracker.data.repository.AuthRepository
import com.luizvicari.moodtracker.ui.auth.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    // ViewModels
    viewModel { SignUpViewModel(get<AuthRepository>()) }
}