package com.example.astonlesson2

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources

import android.os.Build
import java.util.*


class LanguageConfig {
    companion object {
        fun changeLanguage(context: Context, languageCode: String): ContextWrapper {
            val resources: Resources = context.resources
            val configuration: Configuration = resources.configuration
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            configuration.setLocale(locale)

            return ContextWrapper(context.createConfigurationContext(configuration))
        }
        var currentLanguage = "ru"
    }
}