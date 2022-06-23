package com.example.uptome

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = arrayOf(Activity::class), version = 1, exportSchema = false)
public abstract class ActivityRoomDB : RoomDatabase(){
    abstract fun activityDao() : ActivityDao

    companion object{
        @Volatile
        private var INSTANCE: ActivityRoomDB? = null

        fun getDatabase(context: Context): ActivityRoomDB {
            //if the INSTANCE is not null, return it,
            //if it is, then create the db
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ActivityRoomDB::class.java,
                    "sensors_db"
                ).build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }
}