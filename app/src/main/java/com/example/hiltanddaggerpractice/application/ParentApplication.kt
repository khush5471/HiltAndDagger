package com.example.hiltanddaggerpractice.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ParentApplication : Application() {
}