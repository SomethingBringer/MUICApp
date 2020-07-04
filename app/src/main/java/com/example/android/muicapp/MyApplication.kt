package com.example.android.muicapp

import android.app.Application
import com.example.android.muicapp.di.DaggerAppComponent

class MyApplication: Application() {

    val appComponent = DaggerAppComponent.create()
}