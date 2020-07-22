package com.sns.notifyapp.di

import android.app.Application
import androidx.room.Room
import com.sns.notifyapp.repository.MyDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule(mApplication: Application?) {

    private val mMyDatabase: MyDatabase

    @Singleton
    @Provides
    fun providesRoomDatabase(): MyDatabase {
        return mMyDatabase
    }

    init {
        mMyDatabase = Room.databaseBuilder(mApplication!!, MyDatabase::class.java, "notifydata_db")
                .build()
    }
}