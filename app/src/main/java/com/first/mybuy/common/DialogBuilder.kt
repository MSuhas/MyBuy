package com.first.mybuy.common

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import javax.inject.Inject

class DialogBuilder@Inject constructor(private val context: Context) {
    private var title: Int = -1
    private var message: Int = -1
    private var positiveButtonTitle: Int = -1
    private var negativeButtonTitle: Int = -1
    private var dialogLayout: Int = -1

    public fun setTitle(title: Int): DialogBuilder {
        this.title = title
        return this
    }

    public fun setMessage(message: Int): DialogBuilder {
        this.message = message
        return this
    }

    public fun setPositiveButtonTitle(positiveButtonTitle: Int) : DialogBuilder{
        this.positiveButtonTitle = positiveButtonTitle
        return this
    }

    public fun setNegativeButtonTitle(negativeButtonTitle: Int): DialogBuilder {
        this.negativeButtonTitle = negativeButtonTitle
        return this
    }

    public fun setDialogLayout(dialogLayout: Int): DialogBuilder {
        this.dialogLayout = dialogLayout
        return this
    }

    public fun getCustomAlert(positiveListener: DialogInterface.OnClickListener,
                              negativeListener: DialogInterface.OnClickListener, context: Context) : Dialog{
        val builder = AlertDialog.Builder(context)
        builder.setView(dialogLayout)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(positiveButtonTitle, positiveListener)
        builder.setNegativeButton(negativeButtonTitle, negativeListener)
        builder.setCancelable(false)
        val dialog = builder.create()
        dialog.setCancelable(false)
        return dialog
    }
}