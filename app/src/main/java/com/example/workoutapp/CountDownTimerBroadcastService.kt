package com.example.workoutapp

import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log

class CountDownTimerBroadcastService: Service() {

    var cdt: CountDownTimer? = null
    val millisInTimer = 10000L
    private val TAG = "BroadcastService"



    companion object{
        val COUNTDOWN_BR = "your_package_name.countdown_br"
    }
    var bi = Intent(COUNTDOWN_BR)

    override fun onCreate() {
        super.onCreate()

        createCountDownTimer()
    }

    override fun onDestroy() {

        cdt?.cancel()
        Log.i(TAG, "Timer cancelled");

        super.onDestroy()

    }


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun createCountDownTimer() {
        cdt = object : CountDownTimer(millisInTimer, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                Log.i(TAG, "Countdown seconds remaining: " + millisUntilFinished / 1000);
                bi.putExtra("countdown", millisUntilFinished);
                sendBroadcast(bi);

            }

            override fun onFinish() {
                Log.i(TAG, "Timer finished");
            }
        }

        (cdt as CountDownTimer).start()
    }
}