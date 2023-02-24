package com.example.astonlesson2

object Navigator {
    private var mainActivity: MainActivity? = null

    fun onCreate(activity: MainActivity){
        mainActivity = activity
    }

    fun moveToMainPage(){

    }

    fun moveToVacanciesList(){

    }

    fun moveToOfficesList(){

    }

    fun onDestroy(){
        mainActivity = null
    }
}