package com.example.uptome

import android.app.Application

class SensorApplication : Application() {

    val database by lazy { ActivityRoomDB.getDatabase(this) }
    val repository by lazy { SensorsRepo(database.activityDao())}
}