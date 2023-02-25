package com.example.astonlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.astonlesson2.databinding.ActivityMainBinding
import com.example.astonlesson2.fragments.AuthorisationFragment

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Navigator.onCreate(this)

        binding.bottomNavigationView.setOnItemReselectedListener {
            when(it.itemId){
                R.id.home_page_fragment -> {
                    binding.toolBar.title = "Home"
                    Navigator.moveToHomePage()
                }
                R.id.vacancies_fragment -> {
                    binding.toolBar.title = "Vacancies"
                    Navigator.moveToVacanciesList()
                }
                R.id.offices_fragment -> {
                    binding.toolBar.title = "Offices"
                    Navigator.moveToOfficesList()
                }
            }
        }
        binding.toolBar.setNavigationOnClickListener {
            supportFragmentManager.popBackStack()
            Navigator.moveToOfficesList()
            binding.toolBar.navigationIcon = null
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, AuthorisationFragment.newInstance())
            .commit()

    }

    override fun onDestroy() {
        Navigator.onDestroy()
        super.onDestroy()
    }
}