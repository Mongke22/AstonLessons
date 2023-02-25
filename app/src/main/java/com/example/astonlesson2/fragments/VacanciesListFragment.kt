package com.example.astonlesson2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.astonlesson2.Navigator
import com.example.astonlesson2.models.Vacancy
import com.example.astonlesson2.databinding.FragmentVacanciesListBinding
import com.example.astonlesson2.recycler.adapters.VacancyListAdapter

class VacanciesListFragment : Fragment() {

    private var _binding: FragmentVacanciesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var vacancyListAdapter: VacancyListAdapter

    private var wholeVacancyList = ArrayList<Vacancy>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Navigator.moveToHomePage()
            }
        })
    }
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
        binding.etSearch.etVacancy.setOnClickListener {
            binding.etSearch.etVacancy.setText("")
        }
        binding.etSearch.ivSearch.setOnClickListener {
            val vacancyArray = getSearchingVacancies(binding.etSearch.etVacancy.text.toString())
            vacancyListAdapter.submitList(vacancyArray)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun parseParams(){
        val args = requireArguments()
        if(args.containsKey(VACANCIES_LIST_TAG)){
            wholeVacancyList = args.getSerializable(VACANCIES_LIST_TAG) as ArrayList<Vacancy>
            vacancyListAdapter.submitList(wholeVacancyList)
        }
    }

    private fun setupRecyclerView() {
        vacancyListAdapter = VacancyListAdapter()
        with(binding.rvVacanciesList) {
            adapter = vacancyListAdapter
        }
    }

    private fun getSearchingVacancies(vacancy: String): ArrayList<Vacancy>{
        val result = ArrayList<Vacancy>()
        for(vac in wholeVacancyList){
            if(vac.title.lowercase().contains(vacancy.lowercase())){
                result.add(vac)
            }
        }
        return result
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