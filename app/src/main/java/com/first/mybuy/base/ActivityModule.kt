package com.first.mybuy.base

import com.first.mybuy.home.HomeActivity
import com.first.mybuy.login.LoginActivity
import com.first.mybuy.signup.SignUpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector()
    abstract fun contributeSignUpActivity(): SignUpActivity

    @ContributesAndroidInjector()
    abstract fun contributeHomeActivity(): HomeActivity
}