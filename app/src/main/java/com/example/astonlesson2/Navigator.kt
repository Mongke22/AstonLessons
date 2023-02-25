package com.example.astonlesson2

import com.example.astonlesson2.fragments.HomePageFragment
import com.example.astonlesson2.fragments.VacanciesListFragment
import com.example.astonlesson2.models.Vacancy

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
            Vacancy(1, R.drawable.aston_logo, "Python developer", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(2, R.drawable.aston_logo, "Android developer", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(3, R.drawable.aston_logo, "Middle Android developer", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(4, R.drawable.aston_logo, "Flutter developer", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(5, R.drawable.aston_logo, "Lead Android developer", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(6, R.drawable.aston_logo, "IOS developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(7, R.drawable.aston_logo, "Full stack developer", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(8, R.drawable.aston_logo, "Java developer", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(9, R.drawable.aston_logo, "Android developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(10, R.drawable.aston_logo, "Android developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(11, R.drawable.aston_logo, "Android developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(12, R.drawable.aston_logo, "Android developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(13, R.drawable.aston_logo, "Android developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(14, R.drawable.aston_logo, "Android developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(15, R.drawable.aston_logo, "Android developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(16, R.drawable.aston_logo, "Android developer trainee", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(17, R.drawable.aston_logo, "Title9", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(18, R.drawable.aston_logo, "Title10", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(19, R.drawable.aston_logo, "Title11", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(20, R.drawable.aston_logo, "Title11", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(21, R.drawable.aston_logo, "Title11", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
            Vacancy(22, R.drawable.aston_logo, "Title11", "Мы – аутсорсинговая аккредитованная IT-компания Aston. С нами вы сможете хорошо зарабатывать, работать над масштабными проектами и профессионально расти в команде."),
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