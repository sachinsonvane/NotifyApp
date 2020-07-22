package com.sns.notifyapp.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sns.notifyapp.model.NotifyData


@Database(entities = [NotifyData::class], version = MyDatabase.VERSION)
abstract class MyDatabase : RoomDatabase() {
   // abstract val productDao: ProductDao?

    companion object {
        const val VERSION = 1
    }

    abstract fun getNotifyDAO(): NotifyDAO
}