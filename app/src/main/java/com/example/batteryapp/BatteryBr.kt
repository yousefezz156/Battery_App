package com.example.batteryapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.runtime.MutableState

class BatteryBr(private var batteryimage: MutableState<Int>) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BATTERY_OKAY)
            batteryimage.value = R.drawable.battery_full
        else if (intent.action == Intent.ACTION_BATTERY_LOW)
            batteryimage.value = R.drawable.battery_low

    }

    fun receive (context: Context, batteryImage : MutableState<Int>)
    {
        context.registerReceiver(
            BatteryBr(batteryImage), IntentFilter(Intent.ACTION_BATTERY_LOW).apply {
                addAction(Intent.ACTION_BATTERY_OKAY)
            })
    }

}
