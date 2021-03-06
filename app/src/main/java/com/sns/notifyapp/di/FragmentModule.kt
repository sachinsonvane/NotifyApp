package com.sns.notifyapp.di

import com.sns.notifyapp.view.NotifyDetailsFragment
import com.sns.notifyapp.view.NotifyListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule{

    @ContributesAndroidInjector
    abstract fun contributeNotifyListFragment() : NotifyListFragment

    @ContributesAndroidInjector
    abstract fun contributeNotifyDetailsFragment() : NotifyDetailsFragment

}