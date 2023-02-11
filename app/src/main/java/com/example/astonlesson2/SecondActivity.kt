package com.example.astonlesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<Button>(R.id.btn_back)
        val etText = findViewById<EditText>(R.id.et_text)
        btnBack.setOnClickListener {
            val data = Intent()
            data.putExtra(SecondActivityContract.RESULT_KEY, etText.text)
            setResult(RESULT_OK, data)
            finish()
        }
    }
}