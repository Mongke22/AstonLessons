package com.example.astonlesson2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class VacanciesListFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vacancies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parseParams()
    }

    private fun parseParams(){
        val args = requireArguments()
        if(args.containsKey(VACANCIES_LIST_TAG)){
            val list = args.getSerializable(VACANCIES_LIST_TAG) as ArrayList<Vacancy>
            for(i in list){
                Log.i("element", i.toString())
            }
        }
    }

    companion object {

        private const val VACANCIES_LIST_TAG = "vacancies"

        fun newInstance(vacanciesList: ArrayList<Vacancy>): VacanciesListFragment{
            return VacanciesListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(VACANCIES_LIST_TAG, vacanciesList)
                }
            }
        }
    }
}