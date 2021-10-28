package com.first.mybuy.home

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.first.mybuy.R
import com.first.mybuy.base.BaseActivity
import com.first.mybuy.common.DialogBuilder
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity: BaseActivity() {

    

    @Inject
    internal lateinit var dialogBuilder: DialogBuilder

    private lateinit var addItem1: ImageView

    companion object{
        fun startHomeActivity(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        addItem = getToolBar().findViewById(R.id.img_add_item)
        addItem.setOnClickListener { showAddItemView(this) }
    }

    override fun getResourceLayoutId(): Int {
       return R.layout.activity_home
    }

    override fun hasToolBar(): Boolean {
        return true
    }

    override fun isBackButtonEnabled(): Boolean {
        return true
    }

    private fun showAddItemView(context: Context) {
        dialogBuilder
            .setTitle(R.string.add)
            .setMessage(R.string.message)
            .setPositiveButtonTitle(R.string.positive)
            .setNegativeButtonTitle(R.string.cancel)
            .setDialogLayout(R.layout.dialog_test)
            .getCustomAlert(DialogInterface.OnClickListener { dialog, which ->  Toast.makeText(context,"okkk",Toast.LENGTH_SHORT).show()},
            DialogInterface.OnClickListener{dialog, which -> dialog.dismiss()}, this)
            .show()
    }
}