package com.example.uptome

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class SensorApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ActivityRoomDB.getDatabase(this, applicationScope) }
    val repository by lazy { SensorsRepo(database.activityDao())}
}