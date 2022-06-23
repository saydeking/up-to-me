package com.example.uptome

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {

    @Query("SELECT * FROM activity")
    fun getActivity(): Flow<List<Activity>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(activity: Activity)
}