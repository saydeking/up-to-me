package com.example.uptome

import androidx.room.ColumnInfo
import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Activity(

   // data class Activity(
     //   val sensed_activity: String,
       // val if_subscribed: Boolean,
        //val start_time: String,
        //val end_time: String,
        //val location: String,
        //val user_id: String
        //)


    //class Activity(
        @PrimaryKey val sensed_activity: String,
        //@ColumnInfo(name = "sensed_activity") val sensed_activity: String,
        @ColumnInfo(name = "if_subscribed") val if_subscribed: Boolean,
        @ColumnInfo(name = "start_time") val start_time: String,
        @ColumnInfo(name = "end_time") val end_time: String
        )
