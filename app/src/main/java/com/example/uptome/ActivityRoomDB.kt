package com.example.uptome

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database (entities = arrayOf(Activity::class), version = 1, exportSchema = false)
public abstract class ActivityRoomDB : RoomDatabase(){
    abstract fun activityDao() : ActivityDao

    private class ActivityDBCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var activityDao = database.activityDao()

                    //add sample words
                    var activity = Activity("run",true,"05-04-2022, 16:04","05-04-2022, 16:15")
                    activityDao.insert(activity)
                    activity = Activity("walk",true,"05-04-2022, 16:15","05-04-2022, 16:20")
                    activityDao.insert(activity)
                }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: ActivityRoomDB? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ActivityRoomDB {
            //if the INSTANCE is not null, return it,
            //if it is, then create the db
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ActivityRoomDB::class.java,
                    "sensors_db"
                )
                    .addCallback(ActivityDBCallback(scope))
                    .build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }
}