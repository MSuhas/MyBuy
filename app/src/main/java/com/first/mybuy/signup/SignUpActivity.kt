package com.first.mybuy.signup

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString
import android.text.style.ImageSpan
import com.first.mybuy.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import javax.inject.Inject

class SignUpActivity : AppCompatActivity(), SignUpContract.View{

    @Inject
    internal lateinit var signUpPresenter: SignUpPresenter

    companion object{

        fun startSignUpActivity(context: Context) {
            val activity = context as AppCompatActivity
            activity.startActivityForResult(Intent(context, SignUpActivity::class.java), RESULT_CODE)
        }

        const val RESULT_CODE = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpPresenter.setView(this)
        signUpPresenter.setCompositeDispossible()
        submit_button.setOnClickListener { signUpPresenter.onSubmitClicked(txt_sign_up_username.text.toString(), txt_sign_up_password.text.toString()) }
    }

    override fun showLogin() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun showError() {

    }
}
