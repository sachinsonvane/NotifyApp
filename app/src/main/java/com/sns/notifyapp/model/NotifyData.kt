package com.sns.notifyapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifys")
data class NotifyData(

    @PrimaryKey
    var id:String,
    var title:String,
    var desc:String,
    var time:Long
){
    override fun toString() = title
}