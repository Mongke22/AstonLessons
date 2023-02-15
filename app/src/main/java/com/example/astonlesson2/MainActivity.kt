package com.example.astonlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.constraintlayout.widget.Group
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {

    private lateinit var firstBtn: Button
    private lateinit var secondBtn: Button
    private lateinit var thirdBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstBtn = findViewById(R.id.firstBtn)
        secondBtn = findViewById(R.id.secondBtn)
        thirdBtn = findViewById(R.id.thirdBtn)

        setListeners()
    }

    private fun setListeners(){
        firstBtn.setOnClickListener {
            hideButtonsAndShowProgress()
        }
        secondBtn.setOnClickListener {
            hideButtonsAndShowProgress()
        }
        thirdBtn.setOnClickListener {
            hideButtonsAndShowProgress()
        }
    }

    private fun hideButtonsAndShowProgress(){
        val groupToHide = findViewById<Group>(R.id.groupToHide)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        groupToHide.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }
}