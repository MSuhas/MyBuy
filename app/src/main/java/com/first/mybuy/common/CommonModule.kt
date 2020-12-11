package com.first.mybuy.common

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CommonModule {
    @Provides
    @Singleton
    public fun providesDialogBuilder(context: Context): DialogBuilder{
        return DialogBuilder(context)
    }
}