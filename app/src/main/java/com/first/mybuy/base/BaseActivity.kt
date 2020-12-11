package com.first.mybuy.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.first.mybuy.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResourceLayoutId())
        setupToolBar()
    }

    protected abstract fun getResourceLayoutId(): Int

    protected abstract fun hasToolBar(): Boolean

    protected abstract fun isBackButtonEnabled(): Boolean

    private fun setupToolBar() {
        if (hasToolBar()) {
            setSupportActionBar(findViewById(R.id.my_buy_toolbar))
            supportActionBar?.setDisplayHomeAsUpEnabled(isBackButtonEnabled())
        }
    }

    public fun getToolBar(): Toolbar {
        return findViewById(R.id.my_buy_toolbar)
    }
}
