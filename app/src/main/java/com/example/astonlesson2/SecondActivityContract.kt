package com.example.astonlesson2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class SecondActivityContract: ActivityResultContract<Unit, String?>() {
    override fun createIntent(context: Context, input: Unit): Intent {
        return Intent(context, SecondActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? = when {
        resultCode != Activity.RESULT_OK -> null
        else -> intent?.getStringExtra("my_result_key")
    }

}