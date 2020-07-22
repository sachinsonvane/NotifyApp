package com.sns.notifyapp

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.sns.notifyapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector, LifecycleObserver {

    @Inject
    lateinit var mActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = mActivityInjector

    private var mAlarmMgr: AlarmManager? = null
    private lateinit var mAlarmIntent: PendingIntent
    val INTERVAL_TIME:Long = 60000

    var mSharedPreferences: SharedPreferences? = null
    private val mSharedPrefFile = "notifyapp_sharedpreference"

    companion object{
        var mInstance:MyApplication? = null;
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        DaggerAppComponent.create().inject(this)

        mSharedPreferences = this.getSharedPreferences(mSharedPrefFile, Context.MODE_PRIVATE)
        initializeAlaram();
    }

    fun initializeAlaram(){

        mAlarmMgr = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        mAlarmIntent = Intent(applicationContext, NotifyReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        if (Build.VERSION.SDK_INT >= 24) {
            mAlarmMgr?.setInexactRepeating(
                AlarmManager.ELAPSED_REALTIME_WAKEUP, 0,
                INTERVAL_TIME,
                mAlarmIntent
            )
        } else {
            if (Build.VERSION.SDK_INT >= 19) {
                mAlarmMgr?.setExact(AlarmManager.RTC_WAKEUP, INTERVAL_TIME, mAlarmIntent)
            } else {
                mAlarmMgr?.set(AlarmManager.RTC_WAKEUP, INTERVAL_TIME, mAlarmIntent)
            }
        }
    }


    fun isBackground():String{
        return ProcessLifecycleOwner.get().getLifecycle().currentState.name
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground(){
        System.out.println("## app onMoveToForeground ")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
        System.out.println("## app onMoveToBackground ")

    }
}