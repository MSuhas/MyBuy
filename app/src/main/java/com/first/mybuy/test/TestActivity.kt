package com.first.mybuy.test

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import com.first.mybuy.R
import com.first.mybuy.service.KillService
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer

import kotlinx.android.synthetic.main.activity_test.*
import java.util.*
import java.util.concurrent.TimeUnit
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.functions.Function3

class TestActivity : AppCompatActivity(), BlankFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        setSupportActionBar(toolbar)
        zip()
        addFragment()
        //startService( Intent(baseContext, KillService::class.java))
        Book("")
        fab.setOnClickListener { startActivityForResult(Intent(this, Main2Activity::class.java), 100) }
    }



    private fun addFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_content, BlankFragment.newInstance("",""))
        transaction.commit()
    }
    private fun testfun() {
        var values = mutableListOf<Int>(1,2,3,4,5)
        values.binarySearchBy(10) { it }
    }

    private fun zip() {
        val obs1 = Observable.just(1, 2, 3, 4, 5)
        val obs2 = Observable.just(11, 12, 13, 14, 15)
        val obs3 = Observable.just(111, 121, 131, 141, 151)

        /*Observable.zip(obs1,obs2,obs3, Function3<Int, Int, Int, String>{ t1, t2, t3 -> "$t1 Hi $t2 Ho $t3"}).
            subscribe { Log.e("test1", "$it") }*/

        val list = Arrays.asList(obs1, obs2, obs3)


        Observable.zip(list) { args -> for (i in args){
            "Hi $i"
        }  }.subscribe { Log.e("test1", "$it")  }

    }

    private fun concat() {
        fab.setOnClickListener { view ->
            val obs1 = Observable.just(1, 2, 3, 4, 5)
            val obs2 = Observable.just(11, 12, 13, 14, 15)

            Observable.concat(obs1, obs2).subscribe { Log.e("test1", "$it") }
        }
    }

    private fun merge() {val obs1 = Observable.interval(1, TimeUnit.SECONDS).map { "OB1 $it" }
        val obs2 = Observable.interval(1, TimeUnit.SECONDS).map { "OB2 $it" }


        Observable.merge(obs1, obs2).subscribe { Log.e("test1", "$it") }
    }

    private fun combineLatest() {
        val obs1 = Observable.interval(100, TimeUnit.MILLISECONDS)
        val obs2 = Observable.interval(50, TimeUnit.MILLISECONDS)

        Observable.combineLatest(
            obs1, obs2, BiFunction { obs1: Long, obs2: Long -> "ob1:(100) $obs1 obs2(50): $obs2" })
            .subscribe { Log.e("test1", "$it") }

        val list = Arrays.asList(obs1, obs2)


        Observable.combineLatest(list) { args -> for (i in args){
            "Hi $i"
        } }.subscribe { Log.e("test1", "$it")  }
    }

}
