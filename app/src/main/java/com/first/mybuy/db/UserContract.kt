package com.first.mybuy.db

import android.provider.BaseColumns

object UserContract {

    object UserEntry : BaseColumns{
        const val TABLE_NAME = "_user"
        const val COLUMN_NAME_USERNAME = "user_name"
        const val COLUMN_NAME_PASSWORD = "pssword"
    }

    public const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${UserEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${UserEntry.COLUMN_NAME_USERNAME} TEXT," +
                "${UserEntry.COLUMN_NAME_PASSWORD} TEXT)"

    public const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${UserEntry.TABLE_NAME}"
}