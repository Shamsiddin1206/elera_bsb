package com.example.elera.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elera.Adapters.MentorsRecyclerAdapter
import com.example.elera.AnimHelper
import com.example.elera.database.AppDatabase
import com.example.elera.database.entity.Mentors
import com.example.elera.databinding.FragmentHomeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val appDatabase: AppDatabase by lazy {
        AppDatabase.getInstance(requireContext())
    }
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mentorlist = appDatabase.getUserDao().getAllMentors()
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val animHelper = AnimHelper.newInstance()
        binding.mentorsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mentorsRecyclerView.adapter =
            MentorsRecyclerAdapter(mentorlist as ArrayList<Mentors>, animHelper, requireContext(), object :MentorsRecyclerAdapter.OnPressed{
                override fun onPressed(mentor: Mentors) {

                }
            })
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}