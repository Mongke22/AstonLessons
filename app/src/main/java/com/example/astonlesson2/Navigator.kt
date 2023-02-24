package com.example.astonlesson2

object Navigator {
    private var mainActivity: MainActivity? = null

    fun onCreate(activity: MainActivity){
        mainActivity = activity
    }

    fun moveToHomePage(){
        mainActivity!!.supportFragmentManager.popBackStack()
        mainActivity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomePageFragment.newInstance())
            .commit()

    }

    fun moveToVacanciesList(){

    }

    fun moveToOfficesList(){

    }

    fun onDestroy(){
        mainActivity = null
    }
}