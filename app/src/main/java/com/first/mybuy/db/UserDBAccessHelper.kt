package com.first.mybuy.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.first.mybuy.model.UserResponse
import io.reactivex.Observable

class UserDBAccessHelper(context: Context) {

    private var userDBHelper: UserDBHelper = UserDBHelper(context)

    fun isUserExists(): Observable<Boolean> {
         var cursor: Cursor? = null
        return try {
            //userDBHelper.readableDatabase.rawQuery("SELECT * FROM ${UserContract.UserEntry.TABLE_NAME}", null)
            cursor = userDBHelper.readableDatabase.query(UserContract.UserEntry.TABLE_NAME,null,null,null,null,null,null,null)
            Observable.just(cursor!!.count > 0)
        } catch (exception: Exception) {
            Observable.just(false)
        } finally {
            cursor?.close()
        }
    }

    fun getUser(): Observable<UserResponse> {
        var cursor: Cursor? = null
        try {
            cursor = userDBHelper.readableDatabase?.rawQuery("SELECT * FROM ${UserContract.UserEntry.TABLE_NAME}", null)
            cursor?.let {
                if (it.moveToFirst()) {
                    return Observable.just(
                        UserResponse.User(
                            it.getString(it.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_USERNAME)),
                            it.getString(it.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_PASSWORD))
                        )
                    )
                }
            }
            return Observable.just(UserResponse.UserReadException())
        } catch (exception: Exception) {
            return Observable.just(UserResponse.UserReadException())
        } finally {
            cursor?.let{it.close()}
        }
    }

    fun addUser(userName: String, password: String) : Observable<Boolean> {
        return try {
            val userValues = ContentValues().apply {
                put(UserContract.UserEntry.COLUMN_NAME_USERNAME, userName)
                put(UserContract.UserEntry.COLUMN_NAME_PASSWORD, password)
            }

            val added = userDBHelper.writableDatabase?.insert(UserContract.UserEntry.TABLE_NAME, null, userValues) ?: -1
            Observable.just(added > -1)
        }catch (exception: Exception) {
            Observable.just(false)
        }
    }

    companion object : SingletonHolder<UserDBAccessHelper, Context>(::UserDBAccessHelper)
}