package com.sns.notifyapp.di

import com.sns.notifyapp.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AndroidInjectionModule::class,ActivityModule::class,FragmentModule::class])
interface AppComponent : AndroidInjector<MyApplication> {

}