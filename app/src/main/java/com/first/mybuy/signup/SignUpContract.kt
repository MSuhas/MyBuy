package com.first.mybuy.signup

interface SignUpContract {

    interface Presenter {

        fun onSubmitClicked(username: String, password: String)
        fun setCompositeDispossible()
        fun clearCompositeDispossible()
        fun setView(view: SignUpContract.View)
    }

    interface View {

        fun showLogin()

        fun showError()
    }
}