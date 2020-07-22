package com.sns.notifyapp.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sns.notifyapp.model.NotifyData

@Dao
interface NotifyDAO {

    @Insert
    fun addNotifyData(notifyData: NotifyData) : Long

    @Update
    fun updateNotifyData(book: NotifyData)

    @Delete
    fun deleteNotifyData(book: NotifyData?)

    @Query("SELECT * FROM notifys")
    fun getAllNotifyData() : LiveData<List<NotifyData>>

    @Query("SELECT * FROM notifys WHERE id == :id")
    fun getNotifyDataById(id: String) : LiveData<List<NotifyData>>
}