package com.example.astonlesson2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clock = findViewById<MyCustomClockVIew>(R.id.myCustomClock)
        GlobalScope.launch(Dispatchers.Main) {
            for(i in 1..100){
                if(i % 2 == 0){
                    clock.secondHandColor = Color.BLACK
                    clock.secondHandWidth = 40
                    clock.secondHandLength = 80
                }
                else{
                    clock.secondHandColor = Color.GREEN
                    clock.secondHandWidth = 10
                    clock.secondHandLength = 20
                }
                delay(1000)
                clock.updateTimer()
            }
        }
    }
}