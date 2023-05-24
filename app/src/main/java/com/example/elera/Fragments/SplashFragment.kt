package com.example.elera.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elera.R
import com.example.elera.database.AppDatabase
import com.example.elera.databinding.FragmentSplashBinding
import farrukh.example.reasa.SignInSignUp_fragments.Fill_ProfileFragment
import farrukh.example.reasa.SignInSignUp_fragments.PinCode_Fragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SplashFragment : Fragment() {
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


    lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)


        binding.logo.alpha = 0f
        binding.logo.animate().setDuration(2500).alpha(1f).withEndAction {
            var list_students = appDatabase.getUserDao().getAllStudents()
            if (list_students.isEmpty()){
                parentFragmentManager.beginTransaction().replace(R.id.activitymain, IntroductionFragment()).commit()
            }
            else{
                for (i in list_students){
                    if (i.code == ""){
                        parentFragmentManager.beginTransaction().replace(R.id.activitymain,Fill_ProfileFragment()).commit()
                    }
                    else{
                        parentFragmentManager.beginTransaction().replace(R.id.activitymain,PinCode_Fragment()).commit()
                    }
                }
            }



        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SplashFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}