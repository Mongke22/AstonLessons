package com.example.astonlesson2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.astonlesson2.Navigator
import com.example.astonlesson2.R
import com.example.astonlesson2.databinding.FragmentOfficesListBinding
import com.example.astonlesson2.databinding.FragmentVacanciesListBinding
import com.example.astonlesson2.models.Office
import com.example.astonlesson2.models.Vacancy
import com.example.astonlesson2.recycler.adapters.OfficeListAdapter
import com.example.astonlesson2.recycler.adapters.VacancyListAdapter


class OfficesListFragment : Fragment() {

    private var _binding: FragmentOfficesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var officeListAdapter: OfficeListAdapter

    private var wholeOfficeList = ArrayList<Office>()

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
        _binding = FragmentOfficesListBinding.inflate(inflater, container, false)
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
        if(args.containsKey(OFFICES_LIST_TAG)){
            wholeOfficeList = args.getSerializable(OFFICES_LIST_TAG) as ArrayList<Office>
            officeListAdapter.submitList(wholeOfficeList)
        }
    }

    private fun setupRecyclerView() {
        officeListAdapter = OfficeListAdapter()
        officeListAdapter.onClickFunction = {
            Navigator.moveToDetailOfficeInfo(it)
        }
        with(binding.rvOfficesList) {
            adapter = officeListAdapter
        }
    }

    companion object {
        private const val OFFICES_LIST_TAG = "offices"

        fun newInstance(officesList: ArrayList<Office>): OfficesListFragment {
            return OfficesListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(OFFICES_LIST_TAG, officesList)
                }
            }
        }
    }
}