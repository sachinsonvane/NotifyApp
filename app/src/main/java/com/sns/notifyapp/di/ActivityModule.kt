package com.sns.notifyapp.di

import com.sns.notifyapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun  contributeMainActivity(): MainActivity

}