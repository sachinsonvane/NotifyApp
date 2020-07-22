package com.sns.notifyapp.repository

import androidx.lifecycle.LiveData
import com.sns.notifyapp.model.NotifyData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class DataRepository @Inject constructor(myDatabase: MyDatabase){


    private var mNotifyDAO: NotifyDAO = myDatabase.getNotifyDAO()

    fun getNotifyData(): LiveData<List<NotifyData>> {
        return mNotifyDAO.getAllNotifyData()
    }

    fun getNotifyDataById(id: String): LiveData<List<NotifyData>> {
        return mNotifyDAO.getNotifyDataById(id)
    }

    fun insertNotifyData(notifyData: NotifyData) {
        CoroutineScope(Dispatchers.IO).launch {
            mNotifyDAO.addNotifyData(notifyData)
        }
    }

    fun deleteNotifyData(notifyData: NotifyData) {
        CoroutineScope(Dispatchers.IO).launch {
            mNotifyDAO.deleteNotifyData(notifyData)
        }
    }

    fun updateNotifyData(notifyData: NotifyData) {
        CoroutineScope(Dispatchers.IO).launch {
            mNotifyDAO.updateNotifyData(notifyData)
        }
    }

}