package com.sns.notifyapp.utils

import android.content.SharedPreferences
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.sns.notifyapp.MyApplication
import com.sns.notifyapp.model.NotifyData

object Utilites{

    init {

    }

    /*

    Get Notification when the app is in background after every interval of 1 minute with text as (1 min lapsed, 2 min lapsed ....etc) .
Follow best coding standards and architectural pattern
Submit the assignment by Thursday.
     */

    val WAS_IN_BACKGROUND_KEY = "wasInBackground"

    fun getNotifyListArr():ArrayList<NotifyData>{

        var arr = arrayListOf<NotifyData>()
        arr.add(NotifyData("A","Notify 1","Notify Description",444444))
        arr.add(NotifyData("B","Notify 2","Notify Description",5555555))
        arr.add(NotifyData("C","Notify 3","Notify Description",455454445))

        return arr
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun saveStringData(key:String, value:String){
        val editor: SharedPreferences.Editor =  MyApplication.mInstance!!.mSharedPreferences!!.edit()
        editor.putString(key,value)
        editor.apply()
        editor.commit()
    }
    fun getStringData(key:String): String? {

        return MyApplication.mInstance!!.mSharedPreferences!!.getString(key,"")
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun saveBooleanData(key:String, value:Boolean){
        val editor: SharedPreferences.Editor =  MyApplication.mInstance!!.mSharedPreferences!!.edit()
        editor.putBoolean(key,value)
        editor.apply()
        editor.commit()
    }
    fun getBooleanData(key:String):Boolean?{
        return MyApplication.mInstance!!.mSharedPreferences!!.getBoolean(key,false)
    }

    fun clearAllSharedPreferences(){
        val editor = MyApplication.mInstance!!.mSharedPreferences!!.edit()
        editor.clear()
        editor.apply()
    }

    fun showToast(msg:String){
        Toast.makeText(MyApplication.mInstance!!.applicationContext,msg, Toast.LENGTH_SHORT).show()
    }

}

