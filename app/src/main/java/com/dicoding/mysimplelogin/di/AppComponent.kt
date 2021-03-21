package com.dicoding.mysimplelogin.di

import android.content.Context
import com.dicoding.mysimplelogin.HomeActivity
import com.dicoding.mysimplelogin.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        //anotation processor @BindsIntance diguanakan ketika depedenji membutuhkan context
        fun create(@BindsInstance context: Context) : AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
}