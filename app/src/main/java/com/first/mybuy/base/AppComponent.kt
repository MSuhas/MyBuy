package com.first.mybuy.base

import android.app.Application
import android.content.Context
import com.first.mybuy.db.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [DatabaseModule::class,
    ActivityModule::class,
    PresenterModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        @BindsInstance
        fun getContext(context: Context): Builder
        fun build(): AppComponent
    }
    /*
     * This is our custom Application class
     * */
    fun inject(appController: AppController)


}

