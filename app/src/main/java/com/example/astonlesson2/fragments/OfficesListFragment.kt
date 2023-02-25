package com.example.astonlesson2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.astonlesson2.R
import com.example.astonlesson2.databinding.FragmentOfficesListBinding
import com.example.astonlesson2.databinding.FragmentVacanciesListBinding
import com.example.astonlesson2.models.Office
import com.example.astonlesson2.models.Vacancy
import com.example.astonlesson2.recycler.adapters.VacancyListAdapter


class OfficesListFragment : Fragment() {

    private var _binding: FragmentOfficesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var officeListAdapter: OfficeListAdapter

    private var wholeOfficeList = ArrayList<Office>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOfficesListBinding.inflate(inflater, container, false)
        return  _binding!!.root
    }

    private fun parseParams(){
        val args = requireArguments()
        if(args.containsKey(OfficesListFragment.OFFICES_LIST_TAG)){
            wholeOfficeList = args.getSerializable(OfficesListFragment.OFFICES_LIST_TAG) as ArrayList<Office>
            officeListAdapter.submitList(wholeOfficeList)
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