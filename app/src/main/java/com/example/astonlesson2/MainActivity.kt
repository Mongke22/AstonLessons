package com.example.astonlesson2

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var btnSwitchToRussian: Button
    private lateinit var btnSwitchToEnglish: Button
    private lateinit var btnSwitchToSecondActivity: Button
    private lateinit var someText: TextView
    private val activityLauncher = registerForActivityResult(SecondActivityContract()) { result ->
        if(!result.isNullOrEmpty()) {
            someText.text = result
        }
    }
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
        someText = findViewById(R.id.tv_someText)
        setListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(SecondActivityContract.RESULT_KEY, someText.text.toString());
        super.onSaveInstanceState(outState);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        someText.text = (savedInstanceState.getString(SecondActivityContract.RESULT_KEY))
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
            activityLauncher.launch(Unit)
        }
    }
}