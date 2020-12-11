package com.first.mybuy.login

import android.os.Bundle
import com.first.mybuy.R
import com.first.mybuy.base.BaseActivity
import kotlinx.coroutines.*

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shouldShowLoginScreen()
    }

    override fun getResourceLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun hasToolBar(): Boolean {
        return false
    }

    override fun isBackButtonEnabled(): Boolean {
        return false
    }

    private fun shouldShowLoginScreen() {
        GlobalScope.launch(Dispatchers.Default, CoroutineStart.DEFAULT) {
            delay(5000)
            finish()
            LoginActivity.startLoginActivity(this@SplashActivity)
        }
    }
}
