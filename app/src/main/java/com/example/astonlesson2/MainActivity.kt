package com.example.astonlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var prevBtn: ImageView
    private lateinit var nextBtn: ImageView

    private var currentLayout: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_layout_screen)
        prevBtn = findViewById(R.id.prev)
        nextBtn = findViewById(R.id.next)

        setListeners()
    }

    private fun setListeners(){
        prevBtn.setOnClickListener{
            changeState(false)
        }
        nextBtn.setOnClickListener{
            changeState(true)
        }
    }

    private fun changeState(nextLayout: Boolean){
        if(nextLayout){
            if(currentLayout == 2){
                currentLayout = 0
            }else {
                currentLayout++
            }
        }else{
            if(currentLayout == 0){
                currentLayout = 2
            }else {
                currentLayout--
            }
        }
        when(currentLayout){
            0 -> setContentView(R.layout.frame_layout_screen)
            1 -> setContentView(R.layout.grid_layout_screen)
            2 -> setContentView(R.layout.linear_layout_screen)
        }
        prevBtn = findViewById(R.id.prev)
        nextBtn = findViewById(R.id.next)
        prevBtn.setOnClickListener{
            changeState(false)
        }
        nextBtn.setOnClickListener{
            changeState(true)
        }
    }
}