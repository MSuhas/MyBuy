package com.first.mybuy.login

import com.first.mybuy.db.UserDBAccessHelper
import com.first.mybuy.model.UserResponse
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userDBAccessHelper: UserDBAccessHelper): LoginContract.Presenter{
    private lateinit var  view: LoginContract.View
    private lateinit var  disposable: CompositeDisposable


    override fun onViewCreated() {
        val add = userDBAccessHelper.isUserExists().flatMap {
            if (it) {
                userDBAccessHelper.getUser()
            } else {
                Observable.just(UserResponse.NoUserException())
            }
        }.subscribe {
            when (it) {
                is UserResponse.User -> {
                    view.setUserData(it.userName, it.password)
                }
                is UserResponse.NoUserException -> {
                    view.showSignUp()
                }
                is UserResponse.UserReadException -> {
                    view.setError("")
                }
                else -> {
                    view.setError("")
                }
            }
        }

        disposable.add(add)
    }

    override fun setView(view: LoginContract.View) {
        this.view = view
        setCompositeDispossible()
    }
    override fun setCompositeDispossible() {
        disposable = CompositeDisposable()
    }
    override fun clearCompositeDispossible() {
        disposable.let {
            disposable.clear()
        }
    }
}