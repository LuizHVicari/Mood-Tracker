package com.luizvicari.moodtracker

import android.app.Application
import com.luizvicari.moodtracker.di.appModule
import com.luizvicari.moodtracker.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MoodTrackerApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MoodTrackerApp)
            modules(listOf(appModule, authModule))
        }
    }
}