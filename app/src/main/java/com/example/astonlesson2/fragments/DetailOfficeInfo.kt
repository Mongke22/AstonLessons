package com.example.astonlesson2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.astonlesson2.Navigator
import com.example.astonlesson2.R
import com.example.astonlesson2.databinding.FragmentDetailOfficeInfoBinding
import com.example.astonlesson2.databinding.FragmentOfficesListBinding
import com.example.astonlesson2.models.Office
import com.google.android.material.appbar.MaterialToolbar

class DetailOfficeInfo : Fragment() {

    private var _binding: FragmentDetailOfficeInfoBinding? = null
    private val binding get() = _binding!!

    private lateinit var office: Office

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Navigator.moveToHomePage()
                    requireActivity().findViewById<MaterialToolbar>(R.id.toolBar).navigationIcon = null
                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailOfficeInfoBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parseParams()
        binding.ivIcon.setImageResource(office.flag)
        binding.tvAddress.text = office.location
        binding.tvCity.text = office.city
        binding.tvCountry.text = office.country
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun parseParams() {
        val args = requireArguments()
        if (args.containsKey(OFFICE_TAG)) {
            office = args.getSerializable(OFFICE_TAG) as Office
        }
    }

    companion object {
        private const val OFFICE_TAG = "office"
        fun newInstance(office: Office): DetailOfficeInfo {
            return DetailOfficeInfo().apply {
                arguments = Bundle().apply {
                    putSerializable(OFFICE_TAG, office)
                }
            }
        }
    }
}