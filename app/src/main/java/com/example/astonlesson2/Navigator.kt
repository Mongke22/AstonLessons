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
        val myList: ArrayList<Vacancy> = arrayListOf(
            Vacancy(1, R.drawable.aston_logo, "Title", "subtitle"),
            Vacancy(2, R.drawable.aston_logo, "Title1", "subtitle"),
            Vacancy(3, R.drawable.aston_logo, "Title2", "subtitle"),
            Vacancy(4, R.drawable.aston_logo, "Title3", "subtitle"),
            Vacancy(5, R.drawable.aston_logo, "Title4", "subtitle"),
            Vacancy(6, R.drawable.aston_logo, "Title5", "subtitle"),
            Vacancy(7, R.drawable.aston_logo, "Title6", "subtitle"),
            Vacancy(8, R.drawable.aston_logo, "Title7", "subtitle"),
            Vacancy(9, R.drawable.aston_logo, "Title8", "subtitle"),
            Vacancy(10, R.drawable.aston_logo, "Title9", "subtitle"),
            Vacancy(11, R.drawable.aston_logo, "Title10", "subtitle"),
            Vacancy(12, R.drawable.aston_logo, "Title11", "subtitle"),
        )
        mainActivity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, VacanciesListFragment.newInstance(myList))
            .addToBackStack(null)
            .commit()
    }

    fun moveToOfficesList(){

    }

    fun onDestroy(){
        mainActivity = null
    }
}