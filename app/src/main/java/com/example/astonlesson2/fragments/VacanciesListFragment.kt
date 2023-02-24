package com.example.astonlesson2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.astonlesson2.models.Vacancy
import com.example.astonlesson2.databinding.FragmentVacanciesListBinding
import com.example.astonlesson2.recycler.adapters.VacancyListAdapter

class VacanciesListFragment : Fragment() {

    private var _binding: FragmentVacanciesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var vacancyListAdapter: VacancyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVacanciesListBinding.inflate(inflater, container, false)
        return  _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        parseParams()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun parseParams(){
        val args = requireArguments()
        if(args.containsKey(VACANCIES_LIST_TAG)){
            val list = args.getSerializable(VACANCIES_LIST_TAG) as ArrayList<Vacancy>
            for(i in list){
                Log.i("element", i.toString())
            }
            vacancyListAdapter.submitList(list)
        }
    }

    private fun setupRecyclerView() {
        vacancyListAdapter = VacancyListAdapter()
        with(binding.rvVacanciesList) {
            adapter = vacancyListAdapter
        }
    }


    companion object {

        private const val VACANCIES_LIST_TAG = "vacancies"

        fun newInstance(vacanciesList: ArrayList<Vacancy>): VacanciesListFragment {
            return VacanciesListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(VACANCIES_LIST_TAG, vacanciesList)
                }
            }
        }
    }
}