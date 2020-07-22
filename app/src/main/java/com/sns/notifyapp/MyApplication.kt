package com.sns.notifyapp

import android.app.Application
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

    companion object{
        var mInstance:MyApplication? = null;
    }

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        DaggerAppComponent.create().inject(this)
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