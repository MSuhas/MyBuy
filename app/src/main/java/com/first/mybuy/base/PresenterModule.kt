package com.first.mybuy.base

import com.first.mybuy.db.UserDBAccessHelper
import com.first.mybuy.login.LoginPresenter
import com.first.mybuy.signup.SignUpPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Singleton
    @Provides
    internal fun providesLoginPresenter(userDBAccessHelper: UserDBAccessHelper) : LoginPresenter {
        return LoginPresenter(userDBAccessHelper)
    }

    @Singleton
    @Provides
    internal fun providesSignUpPresenter(userDBAccessHelper: UserDBAccessHelper) : SignUpPresenter {
        return SignUpPresenter(userDBAccessHelper)
    }
}