package com.example.batteryapp

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.batteryapp.ui.theme.BatteryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BatteryAppTheme {
                batteryAction()
            }
        }

    }
}

@Composable
fun batteryAction (modifier: Modifier = Modifier) {

    val context = LocalContext.current

    val img = remember {
        mutableIntStateOf(R.drawable.battery_low)
    }

    var batteryBr =BatteryBr(img).receive(context, img)

    Box (modifier  = modifier.fillMaxSize()){
        batteryBr
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = img.intValue ),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun battery_Prev() {
batteryAction()
}

