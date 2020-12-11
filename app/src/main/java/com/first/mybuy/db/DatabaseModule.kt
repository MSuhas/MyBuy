package com.first.mybuy.db

import android.content.Context
import com.first.mybuy.db.UserDBAccessHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    internal fun providesUserDBAccessHelper(context: Context) : UserDBAccessHelper {
        return UserDBAccessHelper.getInstance(context)
    }
}