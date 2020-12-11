package com.first.mybuy.test

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.first.mybuy.R
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        btn2.setOnClickListener {
            startActivityForResult(Intent(this, Main4Activity::class.java), 109)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e("result", "{$resultCode $requestCode }gained 3")
        setResult(Activity.RESULT_OK)
        finish()
        super.onActivityResult(requestCode, resultCode, data)
    }
}
