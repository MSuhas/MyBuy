package com.first.mybuy.test

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.first.mybuy.R
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        btn3.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}
