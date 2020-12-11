package com.first.mybuy.login

import android.view.View

interface LoginContract {
    interface Presenter {
        fun setView(view: View)
        fun onViewCreated()
        fun setCompositeDispossible()
        fun clearCompositeDispossible()
    }

    interface View {
        fun showLogin()
        fun showSignUp()
        fun showHome()
        fun setUserData(userName: String, password: String)
        fun setError(error: String)

    }
}