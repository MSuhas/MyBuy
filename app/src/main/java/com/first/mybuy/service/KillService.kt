package com.first.mybuy.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class KillService: Service() {

    override fun onBind(intent: Intent?): IBinder? {
       return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("KillService", "Service Started");
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("KillService", "Service destroyed");
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        Log.d("KillService", "Killed");

        stopSelf()
    }
}