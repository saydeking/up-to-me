package com.example.uptome

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class SensorsRepo(private val activityDao: ActivityDao) {

    val allActivity: Flow<List<Activity>> = activityDao.getActivity()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(activity: Activity){
        activityDao.insert(activity)
    }
}