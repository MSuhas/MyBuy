package com.first.mybuy.signup

import com.first.mybuy.db.UserDBAccessHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SignUpPresenter @Inject constructor(private val userDBAccessHelper: UserDBAccessHelper) : SignUpContract.Presenter{
    private lateinit var  view: SignUpContract.View
    private lateinit var  disposable: CompositeDisposable

    override fun setCompositeDispossible() {
        disposable = CompositeDisposable()
    }

    override fun clearCompositeDispossible() {
        disposable.clear()
    }

    override fun setView(view: SignUpContract.View) {
        this.view = view
    }

    override fun onSubmitClicked(username: String, password: String) {

        val add = userDBAccessHelper.addUser(username, password)
            .subscribe {if (it) {view.showLogin()} else {view.showError()}}
        disposable.add(add)
    }
}