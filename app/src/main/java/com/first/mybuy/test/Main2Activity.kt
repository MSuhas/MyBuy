package com.first.mybuy.test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.first.mybuy.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn1.setOnClickListener { val intent = Intent(this, Main3Activity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_FORWARD_RESULT
            startActivity(intent)
            finish()
        }

    }

}
