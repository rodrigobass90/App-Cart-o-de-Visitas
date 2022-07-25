package com.rodrigo.businesscard

import android.app.Application

class App : Application() {
    val database by lazy { AppDatabase (context this) {
        val repository by lazy { BusinessCardRepository(database.businessDao ())  }

    }
