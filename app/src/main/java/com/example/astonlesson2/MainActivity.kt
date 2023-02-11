package com.example.astonlesson2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    private lateinit var btnSwitchToRussian: Button
    private lateinit var btnSwitchToEnglish: Button
    private lateinit var btnSwitchToSecondActivity: Button

    override fun attachBaseContext(newBase: Context?) {
        val context: Context = LanguageConfig.changeLanguage(newBase!!, LanguageConfig.currentLanguage)
        super.attachBaseContext(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSwitchToRussian = findViewById<Button>(R.id.btn_russian)
        btnSwitchToEnglish = findViewById<Button>(R.id.btn_english)
        btnSwitchToSecondActivity = findViewById<Button>(R.id.btn_switchToSecondActivity)
        setListeners()
    }

    private fun setListeners(){
        btnSwitchToEnglish.setOnClickListener{
            LanguageConfig.currentLanguage = "en"
            recreate()
        }
        btnSwitchToRussian.setOnClickListener {
            LanguageConfig.currentLanguage = "ru"
            recreate()
        }
        btnSwitchToSecondActivity.setOnClickListener {
            val activityLauncher = registerForActivityResult(SecondActivityContract()) { result ->
                val someText = findViewById<TextView>(R.id.tv_someText)
                someText.text = result
            }
            activityLauncher.launch(Unit)
        }
    }
}