package com.first.mybuy.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.first.mybuy.signup.SignUpActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject
import android.support.design.widget.TextInputLayout
import android.graphics.Typeface
import android.support.v4.content.res.ResourcesCompat
import com.first.mybuy.R
import com.first.mybuy.home.HomeActivity


class LoginActivity : AppCompatActivity(), LoginContract.View {

    @Inject
   internal lateinit var loginPresenter: LoginPresenter

    companion object{
        fun startLoginActivity(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_button.setOnClickListener { HomeActivity.startHomeActivity(this) }
        loginPresenter.setView(this)
        loginPresenter.onViewCreated()
    }

    override fun showLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showHome() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUserData(userName: String, password: String) {
        txt_username.setText(userName)
        txt_password.setText(password)
    }

    override fun setError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSignUp() {
        SignUpActivity.startSignUpActivity(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SignUpActivity.RESULT_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                loginPresenter.onViewCreated()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.clearCompositeDispossible()

    }
}
