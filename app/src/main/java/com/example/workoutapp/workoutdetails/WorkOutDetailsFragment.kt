package com.example.workoutapp.workoutdetails

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workoutapp.CountDownTimerBroadcastService
import com.example.workoutapp.R
import kotlinx.android.synthetic.main.fragment_work_out_details.*


class WorkOutDetailsFragment : Fragment() {

    private var restTimer: CountDownTimer? = null
    private var restProgess = 0

    private val TAG = "BroadcastService"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().startService(
            Intent(context, CountDownTimerBroadcastService::class.java)
        )
        Log.i(TAG, "Started Service")


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work_out_details, container, false)
    }

    override fun onResume() {
        super.onResume()
        requireActivity().registerReceiver(
            br,
            IntentFilter(CountDownTimerBroadcastService.COUNTDOWN_BR)
        );
    }

    override fun onDestroyView() {

        if (restTimer != null) {
            restTimer!!.cancel()
            restProgess = 0
        }

        super.onDestroyView()

    }


    private val br = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, intent: Intent) {

            updateGUI(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().stopService(
            Intent(context, CountDownTimerBroadcastService::class.java)
        )
    }

    private fun updateGUI(intent: Intent) {
        if (intent.extras != null) {
            val millisUntilFinished = intent.getLongExtra("countdown", 0)
            restProgess = (millisUntilFinished / 1000).toInt()
            Log.i(TAG, "current rest progress is $restProgess")
            progressBarExercise?.progress = restProgess
            tvTimer?.text = restProgess.toString()
        }
    }
}